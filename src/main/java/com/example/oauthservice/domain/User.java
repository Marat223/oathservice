package com.example.oauthservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class User implements UserDetails {

    @Id
    private String id;

    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    @Getter(AccessLevel.PRIVATE)
    private List<? extends GrantedAuthority> authorityList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.copyOf(authorityList);
    }
}
