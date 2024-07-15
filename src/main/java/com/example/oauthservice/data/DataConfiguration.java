package com.example.oauthservice.data;

import com.example.oauthservice.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@Configuration
@EnableJpaRepositories(basePackages = {"com.example.oauthservice.data"})
public class DataConfiguration {

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {

            if (null == userRepository.findByUsername("user")) {
                userRepository.save(new User("user", passwordEncoder.encode("password"), true, Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
            }
            if (null == userRepository.findByUsername("admin")) {
                userRepository.save(new User("admin", passwordEncoder.encode("password"), true, Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))));
            }
        };
    }
}
