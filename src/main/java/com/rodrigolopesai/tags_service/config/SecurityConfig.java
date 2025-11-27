package com.rodrigolopesai.tags_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        http.authorizeRequests(
                requests -> requests.requestMatchers("/actuator/**").permitAll().anyRequest().authenticated());

        http.oauth2ResourceServer(oauth -> oauth.jwt());
        return http.build();
    }

}
