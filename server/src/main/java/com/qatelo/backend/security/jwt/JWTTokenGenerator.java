package com.qatelo.backend.security.jwt;

import com.qatelo.backend.security.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JWTTokenGenerator {
	private static final Key key = Jwts.SIG.HS256.key().build();

	public String generateToken(Authentication authentication) {
		String username = authentication.getName();
		Date current = new Date();
		Date expiry = new Date(current.getTime() + SecurityConstants.JWT_EXPIRATION_TIME);

		return Jwts.builder()
				.subject(username)
				.issuedAt(new Date())
				.expiration(expiry)
				.signWith(key)
				.compact();
	}

	public String getUsernameFromJWT(String token) {
		Claims claims = Jwts.parser()
				.verifyWith((SecretKey) key)
				.build()
				.parseSignedClaims(token)
				.getPayload();
		return claims.getSubject();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser()
					.verifyWith((SecretKey) key)
					.build()
					.parseSignedClaims(token);
			return true;
		} catch (Exception e) {
			throw new AuthenticationCredentialsNotFoundException("JWT Token invalid or expired");
		}
	}
}
