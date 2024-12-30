package com.resurant.resturant.filters;

import com.resurant.resturant.config.jwt.TokenHandler;
import com.resurant.resturant.dto.ClientDto;
import com.resurant.resturant.model.Roles;
import com.resurant.resturant.model.Roles;
import com.resurant.resturant.service.client.ClientService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

@Component
public class KeyFilter extends OncePerRequestFilter {
    @Autowired
    private TokenHandler tokenHandler;
    @Autowired
    private ClientService clientService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String key = request.getHeader("Authorization");
        if(!key.contains("Bearer")){
            response.reset();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        String key2 =key.substring(7);
        if(!tokenHandler.verifyToken(key2)){
            response.reset();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

     ClientDto clientDto =  clientService.checkClientWithToken(key2);
            if(Objects.isNull(clientDto)){
                response.reset();
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }


            List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
            for(Roles role: clientDto.getRoles()){
                SimpleGrantedAuthority simpleGrantedAuthority=
                        new SimpleGrantedAuthority(role.toString());
                grantedAuthorityList.add(simpleGrantedAuthority);
            }
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(clientDto,null,
               grantedAuthorityList);

        SecurityContextHolder.getContext().setAuthentication(token);
        filterChain.doFilter(request,response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getServletPath();
        if(path.contains("login") || path.contains("sign_up")){
            return true;
        }
        return false;
    }
}
