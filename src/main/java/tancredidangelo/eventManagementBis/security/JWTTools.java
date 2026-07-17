package tancredidangelo.eventManagementBis.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tancredidangelo.eventManagementBis.exceptionHandling.exceptions.UnauthorizedException;
import tancredidangelo.eventManagementBis.user.User;

import java.util.Date;

@Component
public class JWTTools {

    /// dependency injection secret Key
    private final String secret;

    public JWTTools(@Value("${spring.jwt.secret}") String secret) {
        this.secret = secret;
    }


   /// BUILDER -> create token
    public String generateToken(User user) {
        return Jwts.builder()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60000))
                .subject(String.valueOf(user.getId()))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
    }


    /// PARSER -> verify token
    public void verifyToken(String token) {
        try {
            Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes())).build().parse(token);
        } catch (Exception ex) {
            throw new UnauthorizedException("Issues verifying token. Retry Login.");
        }


    }
}
