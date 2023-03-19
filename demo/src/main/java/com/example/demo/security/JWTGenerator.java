package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * Class that generates the token for the user.
 */
@Component
public class JWTGenerator {

    /**
     * Method that generates a unique token based on the authentication name and used in the users' login.
     *
     * @param authentication
     * @return token
     */
    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + SecurityConstants.JWT_EXPIRATION);

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.JWT_SECRET)
                .compact();
        return token;
    }

    /**
     * Method that returns username details about the token by parsing it.
     *
     * @param token
     * @return username
     */
    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    /**
     * Method that validates the token. If the token is nnot found, an exception will be thrown.
     *
     * @param token
     * @return True if the token is valid, otherwise false.
     * @throws AuthenticationCredentialsNotFoundException
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SecurityConstants.JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect.");
        }
    }
}
