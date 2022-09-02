package com.example.demospringbuddyproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //Headers management
        http.headers(Customizer.withDefaults());
        //Anonymous
        http.anonymous(Customizer.withDefaults());
        //CSRF
        http.csrf(Customizer.withDefaults());
        //Authorize Requests
        http.authorizeRequests(authorizeRequests -> authorizeRequests
                .antMatchers(HttpMethod.POST, "/api/v1/").hasRole("CLIENT")
                .anyRequest().permitAll());
        http.oauth2ResourceServer(Customizer.withDefaults()
        );
        http.oauth2ResourceServer(Customizer.withDefaults()
        );
        //JWT Token
        http.oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer
                .jwt(Customizer.withDefaults())
        );
        http.oauth2Login(oauth2Login -> oauth2Login
                .disable());
        //OAuth 2.0 Login
        return http.build();
    }
}