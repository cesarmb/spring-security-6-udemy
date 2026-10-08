package com.java.app_security.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http.authorizeHttpRequests(auth ->
                        auth.requestMatchers("/loans","/balance","/accounts","/cards").authenticated()
                                .anyRequest().permitAll())
                        .formLogin(Customizer.withDefaults())
                        .httpBasic(Customizer.withDefaults());
        return http.build();
    }
    /*
    @Bean
    InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        var admin = User.withUsername("admin")
                .password("to_be_encoded")
                .authorities("ADMIN")
                .build();
        var user = User.withUsername("user")
                .password("to_be_encoded")
                .authorities("USER")
                .build();
        return new InMemoryUserDetailsManager(admin,user);
    }
    @Bean
    UserDetailsService userDetailsService(DataSource datasource){
        return new JdbcUserDetailsManager(datasource);
    }*/

    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}