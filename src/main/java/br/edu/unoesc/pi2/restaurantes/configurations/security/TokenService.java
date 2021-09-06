package br.edu.unoesc.pi2.restaurantes.configurations.security;

import br.edu.unoesc.pi2.restaurantes.models.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${jwt.expiration}")
    private String tokenExpiration;

    @Value("${jwt.secret}")
    private String tokenSecret;

    public String generateToken(Authentication authentication) {
        var user = (User) authentication.getPrincipal();
        var now = new Date();
        var expirationTime = new Date(now.getTime() + Long.parseLong(tokenExpiration));

        return Jwts.builder()
                .setIssuer("Restaurantes PI2")
                .setSubject(String.valueOf(user.getId()))
                .setIssuedAt(now)
                .setExpiration(expirationTime)
                .signWith(SignatureAlgorithm.HS256, tokenSecret)
                .compact();
    }

    public Boolean isValid(String token) {
        try {
            Jwts.parser().setSigningKey(tokenSecret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Integer getUserId(String token) {
        var body = Jwts.parser().setSigningKey(tokenSecret).parseClaimsJws(token).getBody();
        return Integer.valueOf(body.getSubject());
    }
}
