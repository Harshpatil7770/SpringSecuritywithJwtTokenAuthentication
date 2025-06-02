package com.jwt.security.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtUtil {

	private final String SECRET_KEY = "mysecretkey123456789";
	
	private static final long TOKEN_VALIDITY = 1000 * 60 * 60; // 1 hour

	public String generateToken(String userName) {
	    Date now = new Date();
	    Date expiry = new Date(now.getTime() + TOKEN_VALIDITY);
	    log.info("Token Expire Date  {} ",expiry);
	    return Jwts.builder()
	        .setSubject(userName)
	        .setIssuedAt(now)
	        .setExpiration(expiry)
	        .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes())
	        .compact();
	}

	public String extractUsername(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY.getBytes()).parseClaimsJws(token).
				getBody().getSubject();
	}
}
