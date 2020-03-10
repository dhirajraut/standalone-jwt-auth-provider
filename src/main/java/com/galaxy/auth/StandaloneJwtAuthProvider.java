package com.galaxy.auth;

import org.joda.time.LocalDateTime;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class StandaloneJwtAuthProvider {

	private static final String KEY = "Nm03m1LuozS5m1q8fcbGFAO9d87azkZu";

	public static String generateToken(JwtClaims requiredClaims) {

		LocalDateTime currentDateTime = LocalDateTime.now();

		Claims claims = Jwts.claims().setSubject(requiredClaims.getUserId()).setIssuedAt(currentDateTime.toDate())
				.setExpiration(currentDateTime.plusMinutes(30).toDate());

		String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, KEY).compact();
		return token;
	}

	public static boolean verifyToken(String token, JwtClaims jwtClaims) {
		Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody().getSubject().equals(jwtClaims.getUserId());
		return false;
	}
}
