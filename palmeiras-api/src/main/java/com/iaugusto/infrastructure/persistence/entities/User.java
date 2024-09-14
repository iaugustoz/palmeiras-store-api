package com.iaugusto.infrastructure.persistence.entities;

import com.iaugusto.core.domains.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @Email
    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private UserRole role; // define o tipo de usuário (ADMIN ou CLIENT)

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false; // devo implementar a lógica (por enquanto está o default)
    }

    @Override
    public boolean isAccountNonLocked() {
        return false; // devo implementar a lógica (por enquanto está o default)
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false; // devo implementar a lógica (por enquanto está o default)
    }

    @Override
    public boolean isEnabled() {
        return false; // devo implementar a lógica (por enquanto está o default)
    }
}
