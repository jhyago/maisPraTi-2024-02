package com.example.Integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static org.springframework.security.authorization.AuthenticatedAuthorizationManager.authenticated;

@EnableWebSecurity
public class securityConfig {
    @Bean
    public UserDetailsService userDetailsService () {
        UserDetails user = User.withDefaultPasswordEncoder().username("admin").password("password").roles("USER").build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/usuarios", "/cursos")
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf()
                .disable();
    }
}
