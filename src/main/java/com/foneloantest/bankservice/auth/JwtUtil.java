package com.foneloantest.bankservice.auth;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

//this class is used for creating and resolving jwt tokens
public class JwtUtil {
    private final String secret_key = "9840115582";
    private long accessTokenValidity = 60*60*1000;

    private final JwtParser jwtParser;

    private final String TOKEN_HEADER = "Authorization";
    private final String TOKEN_PREFIX = "Bearer ";

    public JwtUtil(){
        this.jwtParser = Jwts.parser().setSigningKey(secret_key);
    }
}
