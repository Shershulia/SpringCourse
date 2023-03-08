package com.ntnu.ivansh.Building.Restful.Api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        //All request should be autotificated
        httpSecurity.authorizeHttpRequests(
                authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry.anyRequest()
                        .authenticated()
        );
        //IF not authethicated a web page is shown
        httpSecurity.httpBasic(Customizer.withDefaults());

        //Disable csrf
        httpSecurity.csrf().disable();
        return httpSecurity.build();
    }
}
