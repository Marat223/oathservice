package com.example.oauthservice.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

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

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, DataSource dataSource) {
//
//        return builder
//                .dataSource(dataSource)
//                .packages("com.example.oauthservice.domain")
//                .persistenceUnit("User")
//                .build();
//    }

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setDataSource(dataSource);
//        entityManagerFactoryBean.setPackagesToScan("com.example.oauthservice.domain");
//        entityManagerFactoryBean.setPersistenceUnitName("User");
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
//        entityManagerFactoryBean.setJpaProperties(additionalProperties());
//
//        return entityManagerFactoryBean;
//    }
//
//    private Properties additionalProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", "create");
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//
//        return properties;
//    }
}
