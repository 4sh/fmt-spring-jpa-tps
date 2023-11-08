package com.qsh.learning.springRestJpa.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(HttpMethod.GET, "/api/car").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/car/*").authenticated()
                        .requestMatchers(HttpMethod.POST, "/api/car").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/api/car/*").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/api/car/*").authenticated()
                )
                .build();
    }
}
