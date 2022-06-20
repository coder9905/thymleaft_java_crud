package uz.baxtiyor.thymleaft_java.security;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SecurityUtils {
    public Optional<String> getCurrentUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if (securityContext.getAuthentication() != null) {
            return Optional.ofNullable(securityContext.getAuthentication())
                    .map(authentication -> {
                        if (authentication.getPrincipal() instanceof UserDetails) {
                            return ((UserDetails) authentication.getPrincipal()).getUsername();
                        } else if (authentication.getPrincipal() instanceof String) {
                            return (String) authentication.getPrincipal();
                        }
                        return null;
                    });
        }
        return Optional.empty();
    }
}
