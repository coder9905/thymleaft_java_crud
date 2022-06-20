package uz.baxtiyor.thymleaft_java.security;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import uz.baxtiyor.thymleaft_java.entity.Role;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    @Value("${jwt.secret.key}")
    private String secret;

    @Value(("${jwt.token.validity}"))
    private Long validity;

    private final CustomUserDetailsService customUserDetailsService;

    private final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    @PostConstruct
    protected void init() {
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    public String createToken(String username, List<Role> roles) {

        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", roles);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + validity))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    //bearer dan keyin token qowib berib yuboramiz qilib yuboramiz
    public String resolveToken(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        if (token != null && !token.isEmpty()) {
            return token.substring(7);
        }
        return null;
    }

    public boolean validateToken(String token) {
        try {
            Claims claimsJwts = (Claims)Jwts.parser().setSigningKey(secret).parse(token).getBody();
            if (!claimsJwts.getExpiration().before(new Date())) {
                return true;
            }
        } catch (MalformedJwtException e) {
            logger.error(e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error(e.getMessage());
        } catch (PrematureJwtException e) {
            logger.error(e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    //User(username, password)
    public UsernamePasswordAuthenticationToken getAuthentication(String token) {
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(getUser(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    //Jwt -> user ni username ni oliwimiz mumkin
    public String getUser(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

}
