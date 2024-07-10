package com.example.oauthservice.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = {"com.example.oauthservice.data"})
public class DataConfiguration {

    @Bean
    public CommandLineRunner commandLineRunner(/*UserRepository userRepository,*/ PasswordEncoder passwordEncoder) {
        return args -> {

//            userRepository.save(new User("user", passwordEncoder.encode("password"), Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
//            userRepository.save(new User("admin", passwordEncoder.encode("password"), Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))));
        };
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, DataSource dataSource) {

        return builder
                .dataSource(dataSource)
                .packages("com.example.oauthservice.domain")
                .persistenceUnit("demo")
                .build();
    }
}
