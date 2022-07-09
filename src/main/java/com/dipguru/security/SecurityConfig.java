package com.dipguru.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@EnableWebSecurity
public class SecurityConfig {
    private UserAuthenticationSuccessHandler authSuccessHandler;
    @Autowired
    public SecurityConfig(UserAuthenticationSuccessHandler authSuccessHandler) {
        this.authSuccessHandler = authSuccessHandler;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/register").permitAll()
                .anyRequest().authenticated()
            .and().formLogin().loginPage("/").loginProcessingUrl("/login").failureForwardUrl("/").successForwardUrl("/lk")
            .and().httpBasic(withDefaults())
                .logout().permitAll();
        return http.build();
    }
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


