package kurbanoov.restapiwork.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    STUDENT;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
