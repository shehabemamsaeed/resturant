package com.resurant.resturant.config;

import com.resurant.resturant.filters.KeyFilter;
import jakarta.servlet.FilterChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    @Autowired
    KeyFilter keyFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.sessionManagement(http -> http.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        httpSecurity.authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers(HttpMethod.GET, "/category/**").hasRole("CLIENT");
                    authorize.requestMatchers(HttpMethod.POST, "/category/**").hasRole("ADMIN");
                    authorize.requestMatchers(HttpMethod.GET, "/chefs/**").hasRole("CLIENT");
                    authorize.requestMatchers(HttpMethod.POST, "/chefs/**").hasRole("ADMIN");
                    authorize.requestMatchers(HttpMethod.POST, "/product/**").hasRole("ADMIN");
                    authorize.requestMatchers(HttpMethod.GET, "/product/**").hasRole("CLIENT");
                    authorize.requestMatchers(HttpMethod.POST, "/client/sign_up").permitAll();
                    authorize.requestMatchers(HttpMethod.GET, "/client/login").permitAll();
                    authorize.requestMatchers(HttpMethod.GET,"/client/get_all_clients").hasRole("CLIENT");
                }
        );
        httpSecurity.addFilterBefore(keyFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

}
