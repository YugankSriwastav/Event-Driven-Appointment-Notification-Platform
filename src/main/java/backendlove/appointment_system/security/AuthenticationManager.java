package backendlove.appointment_system.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@FunctionalInterface
public interface AuthenticationManager {
    Authentication authentication(Authentication authentication) throws AuthenticationException;
}
