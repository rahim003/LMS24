package kurbanoov.restapiwork.dto.auth;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Beksultan
 */
@Getter @Setter
public class AuthRequest {
    private String email;
    private String password;
}
