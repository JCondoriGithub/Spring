package com.example.demoJwtSecurity.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


public class TokenUtils {

    private final static String ACCESS_TOKEN_SECRET = "fdgdf6846sfdfsfre419fdg2";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;
    
    public static String createToken(String name, String email) {   // si crea un token
        
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;    // si converte il valore in millisecondi
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);    // si trova la data in cui il token scadrà 
        
        Map<String, Object> extra = new HashMap<>();
        extra.put("name", name);
        
        return Jwts.builder()       // si costruisce il token
                .setSubject(email)  // si definisce su cosa si basa il token
                .setExpiration(expirationDate)      // si imposta la data di scandenza
                .addClaims(extra)      // si aggiungono ulteriori dati al token tramite l'hasmap
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))   // si firma il token
                .compact();
    }
    
    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {     // metodo che se ritorna un'istanza della classe, spring potrà dare l'autorizzazione d'accesso all'utente
        
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())  // si imposta la chiave in base al token segreto
                    .build()
                    .parseClaimsJws(token)      // si imposta il token da verifcare
                    .getBody();
            
            String email = claims.getSubject();     // si estrae lo username che identifica lo user
            
            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());   // si ritorna un'istanza della classe con i parametri username e una lista vuota
        } catch (JwtException e) {      // se il token non è più valido
            return null;    // si ritorna null
        }
    }
}
