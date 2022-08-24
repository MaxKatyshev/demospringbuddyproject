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
        //OAuth 2.0 Login
        http.oauth2Login(Customizer.withDefaults());
        //Authorize Requests
        http.authorizeRequests(authorizeRequests -> authorizeRequests
                .antMatchers(HttpMethod.POST, "/api/v1/").hasRole("CLIENT")
                .anyRequest().authenticated());
        //Headers management
        http.headers(Customizer.withDefaults());
        //Anonymous
        http.anonymous(Customizer.withDefaults());
        //CSRF
        http.csrf(Customizer.withDefaults());
        return http.build();
    }
}