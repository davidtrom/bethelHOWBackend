package com.bethelhouseofworship.BethelHOW.Config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultClock;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -2550185165626007488L;

    private Clock clock = DefaultClock.INSTANCE;

    public static final long JWT_TOKEN_VALIDITY = 5*60*60;
    //public static final long JWT_TOKEN_VALIDITY = 5*60*1000;

    //@Value("")
//    @Value("${jwt.secret}")
//    private String secret;
    private final String secret = "thedevilmademedoit";

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getIssuedAtDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        //System.out.println(token);
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        //System.out.println("Expiration: " + expiration);
        return expiration.before(new Date());
    }

    private Boolean ignoreTokenExpiration(String token) {
        // here you specify tokens, for that the expiration is ignored
        return false;
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY*1000)).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public Boolean canTokenBeRefreshed(String token) {
        return (!isTokenExpired(token) || ignoreTokenExpiration(token));
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        //System.out.println("In validateToken username: " + username);
        //System.out.println("In validateToken token: " + token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

//    public String refreshToken(String token) {
//        final Date createdDate = clock.now();
//        final Date expirationDate = calculateExpirationDate(createdDate);
//
//        final Claims claims = getAllClaimsFromToken(token);
//        claims.setIssuedAt(createdDate);
//        claims.setExpiration(expirationDate);
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .signWith(SignatureAlgorithm.HS512, secret)
//                .compact();
//    }

//    private Date calculateExpirationDate(Date createdDate) {
//        return new Date(createdDate.getTime() + expiration * 1000);
//    }


//    public String refreshToken(String token) {
//        validateToken(token);
//        Optional<Jws<Claims>> claimsOpt = this.getClaims(Optional.of(token));
//        if(claimsOpt.isEmpty()) {
//            throw new AuthorizationServiceException("Invalid token claims");
//        }
//        Claims claims = claimsOpt.get().getBody();
//        claims.setIssuedAt(new Date());
//        claims.setExpiration(new Date(Instant.now().toEpochMilli() +
//                validityInMilliseconds));
//        String newToken =
//        Jwts.builder().setClaims(claims).signWith(this.jwtTokenKey,                                                         SignatureAlgorithm.HS256).compact();
//        return newToken;
//    }
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parserBuilder().setSigningKey(this.jwtTokenKey)
//                    .build().parseClaimsJws(token);
//            return true;
//        } catch (JwtException | IllegalArgumentException e) {
//            throw new AuthenticationException("Expired or invalid JWT token",e);
//        }
//    }

}
