package com.example.oauthservice.domain;

import com.example.oauthservice.data.AuthorityListConverter;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "users", schema = "test")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false, unique = true)
    private String username;
    @NonNull
    @Column(nullable = false)
    private String password;
    @NonNull
    @Column(nullable = false)
    private Boolean enabled;
    @NonNull
    @Convert(converter = AuthorityListConverter.class)
    private List<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.copyOf(authorities);
    }
}
