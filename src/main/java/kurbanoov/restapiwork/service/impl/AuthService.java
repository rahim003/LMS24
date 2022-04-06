package kurbanoov.restapiwork.service.impl;

import kurbanoov.restapiwork.dto.auth.AuthRequest;
import kurbanoov.restapiwork.dto.auth.AuthResponse;
import kurbanoov.restapiwork.jwt.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @author Beksultan
 */
@Service
@AllArgsConstructor
public class AuthService {

    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public AuthResponse authenticate(AuthRequest authRequest) {
        Authentication authentication;

        authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authRequest.getEmail(),
                authRequest.getPassword()
        ));

        String generatedToken = jwtUtils.generateToken(authentication);

        return AuthResponse.builder()
                .email(authRequest.getEmail())
                .token(generatedToken)
                .build();
    }
}
