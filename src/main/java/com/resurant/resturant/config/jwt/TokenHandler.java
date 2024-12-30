package com.resurant.resturant.config.jwt;

import com.resurant.resturant.dto.ClientDto;
import com.resurant.resturant.setting.KeyConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Duration;
import java.util.Date;

@Component
public class TokenHandler {

    private JwtBuilder jwtBuilder;
    private JwtParser jwtParser;
    private String secretKey;
    private Duration expDur;

    @Autowired
    TokenHandler(KeyConfig keyConfig) {
        secretKey = keyConfig.getKey();
        expDur = keyConfig.getDur();
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        jwtBuilder = Jwts.builder().signWith(key);
        jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
    }

    public String createToken(ClientDto clientDto) {
        Date issueddate = new Date();
        Date expDate = Date.from(issueddate.toInstant().plus(expDur));
        return jwtBuilder.setSubject(clientDto.getName())
                .setIssuedAt(issueddate)
                .setExpiration(expDate)
                .claim("email", clientDto.getEmail())
                .claim("phone_number", clientDto.getPhoneNumber()).compact();

    }

    public boolean verifyToken(String key) {
        if(jwtParser.isSigned(key)){
            Claims claims = jwtParser.parseClaimsJws(key).getBody();
            Date issuaAt = claims.getIssuedAt();
            Date exp = claims.getExpiration();
            return issuaAt.before(new Date())&&exp.after(new Date());
        }
    return false;
    }

    public String getName(String token) {
    Claims claims = jwtParser.parseClaimsJws(token).getBody();
    String name = claims.getSubject();
    return name;

    }
}
