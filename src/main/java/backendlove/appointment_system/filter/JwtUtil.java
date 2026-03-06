package backendlove.appointment_system.filter;

import backendlove.appointment_system.entity.ROLE;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JwtUtil {
    // hume token banana hai to hume teen chije chahiye ek token kitne time kitne samay tak validate hoga
//    private static final long JWT_TOKEN_VALIDITY = 1000 * 60 * 5;
//
//    // secret key
//
//    private static final String SECRET_KEY =
//            "your-256-bit-secret-your-256-bit-secret";

    // ab hume do chije mil gayi secret key, token expiry ab hume chahiye username jisse token generate hoga aur Claims
    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(String userName, ROLE role, String gmail, Long phNo ){

        // claims
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        claims.put("gmail", gmail);
        claims.put("phoNo",phNo);
        return createToken(claims, userName);

    }

    private String createToken(Map<String, Object> claims, String userName) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName) // username
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(
                        new Date(System.currentTimeMillis() + expiration)
                )
                // Most imp thing getSigningKey() this is created by developer
                // for create token we need subject claims creation date expiry and
                // also signing key which should be hidden
                // .signWith hai do chije leti hai ek key aur dusra algorithm
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }


}
