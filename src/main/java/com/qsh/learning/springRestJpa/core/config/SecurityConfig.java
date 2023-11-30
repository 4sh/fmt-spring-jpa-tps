package com.qsh.learning.springRestJpa.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(new AntPathRequestMatcher( "/api/car", "GET")).authenticated()
                        .requestMatchers(new AntPathRequestMatcher( "/api/car/*", "GET")).hasAnyAuthority("USER", "ADMIN")
                        .requestMatchers(new AntPathRequestMatcher( "/api/car", "POST")).hasAuthority("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher( "/api/car/*", "PUT")).hasAuthority("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher( "/api/car/*", "DELETE")).hasAuthority("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher( "/api/car/with-color/{color}/licensePlate", "GET")).hasAnyAuthority("USER", "ADMIN")
                        .requestMatchers(new AntPathRequestMatcher( "/api/truck", "POST")).hasAuthority("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher( "/api/truck", "GET")).hasAnyAuthority("USER", "ADMIN")
                        .requestMatchers(new AntPathRequestMatcher( "/api/trailer", "POST")).hasAuthority("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher( "/api/trailer", "GET")).hasAnyAuthority("USER", "ADMIN")
                        .requestMatchers(new AntPathRequestMatcher( "/api/summary", "GET")).hasAnyAuthority("USER", "ADMIN")
                        .requestMatchers(new AntPathRequestMatcher( "/actuator/**", "GET")).hasAuthority("ADMIN")
                        .anyRequest().denyAll()
                )
                .httpBasic(httpSecurityHttpBasicConfigurer -> new HttpBasicConfigurer<>())
                .build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder.encode("password"))
                .authorities("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder.encode("admin"))
                .authorities("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }
}
