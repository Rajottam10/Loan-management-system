package com.foneloantest.bankservice.utils;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

//this class is used for creating and resolving jwt tokens
@Component
public class JwtUtil {
    private final String secret_key = "9840115582";
    private long accessTokenValidity = 60*60*1000;

    private final JwtParser jwtParser;

    private final String TOKEN_HEADER = "Authorization";
    private final String TOKEN_PREFIX = "Bearer ";

    public JwtUtil(){
        this.jwtParser = Jwts.parser().setSigningKey(secret_key);
    }

    //creating a jwt token with claims
    public String generateToken(String username){
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + accessTokenValidity))
                .signWith(SignatureAlgorithm.HS256, secret_key)
                .compact();
    }

    //ensure that the token is valid and not expired
    public boolean validateToken(String token){
        try{
            jwtParser.parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //get the username stored in the token
    public String extractUsername(String token){
        return jwtParser.parseClaimsJws(token).getBody().getSubject();
    }

    //extract token from header
    public String resolveToken(String header){
        if(header != null && header.startsWith(TOKEN_PREFIX)){
            return header.substring(TOKEN_PREFIX.length());
        }
        return null;
    }
}
