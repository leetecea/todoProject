package br.ufba.tomorrow.todoProject.domain.services;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class AuthenticationService {
	static final long EXPIRATIONTIME = 1000*60*15;
	static final String SIGNINKEY = "O segredo precisa ser longo para nao dar problema";
	static final String PREFIX = "Bearer";
	private static final SecretKey SECRETKEY = Keys.hmacShaKeyFor(SIGNINKEY.getBytes());
			
	static public void addToken(HttpServletResponse res, String email) {
	    Date now = new Date();
	    Date expirationDate = new Date(now.getTime() + EXPIRATIONTIME);
	    String JwtToken = Jwts.builder()
	        .claim("sub", email)
	        .claim("iat", now.getTime())
	        .claim("exp", expirationDate.getTime())
	        .signWith(SECRETKEY)
	        .compact();

	    res.addHeader("Authorization", PREFIX + " " + JwtToken);
	    res.addHeader("Access-Control-Expose-Headers", "Authorization");
	}
	
	static public Authentication getAuthentication(HttpServletRequest request) {
	    String token = request.getHeader("Authorization");
	    if (token != null) {
	        if (token.startsWith(PREFIX)) token = token.substring(PREFIX.length()).trim();
	        else throw new MalformedJwtException("Invalid Authorization header format");
	        
	        Claims claims = Jwts.parser()
	            .verifyWith(SECRETKEY)
	            .build()
	            .parseSignedClaims(token)
	            .getPayload();
	        
	        String email = claims.get("sub", String.class);
	        if (email != null) 
	            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
	    }
	    return null;
	}
}
