package com.command.center.dev_ops.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean   
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for API endpoints
            .authorizeHttpRequests(requests -> requests
                .requestMatchers(HttpMethod.GET, "/api/health").hasAnyRole("ADMIN", "USER")
                .requestMatchers(HttpMethod.GET, "/api/error-logs").hasAnyRole("ADMIN", "USER")
                .requestMatchers(HttpMethod.POST, "/api/error-logs").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .httpBasic();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        
        var admin = User.builder()
            .username("admin")
            .password(encoder.encode("admin123"))
            .roles("ADMIN") // Spring will automatically add ROLE_ prefix
            .build();
            
        var user = User.builder()
            .username("user")
            .password(encoder.encode("user123"))
            .roles("USER") // Spring will automatically add ROLE_ prefix
            .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}