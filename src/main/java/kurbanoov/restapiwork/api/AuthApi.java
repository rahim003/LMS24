package kurbanoov.restapiwork.api;

import kurbanoov.restapiwork.dto.auth.AuthRequest;
import kurbanoov.restapiwork.dto.auth.AuthResponse;
import kurbanoov.restapiwork.service.impl.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/api/authentication")
@AllArgsConstructor
public class AuthApi {

    private final AuthService authService;

    @PostMapping
    @PermitAll
    public AuthResponse authenticate(@RequestBody AuthRequest authRequest) {
        return authService.authenticate(authRequest);
    }
}
