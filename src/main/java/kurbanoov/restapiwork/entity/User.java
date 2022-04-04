package kurbanoov.restapiwork.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Setter
@Getter
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = SEQUENCE,
            generator = "user_seq")
    @SequenceGenerator(name = "user_seq",
            sequenceName = "user_sequence",
            allocationSize = 1)
    private Long id;
    private String name;
    private String email;
    private Role role;
    private String password;
    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked = true;
    private boolean isCredentialsNonExpired = true;
    private boolean isEnabled = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthorities();
    }

    @Override
    public String getUsername() {
        return email;
    }


}
