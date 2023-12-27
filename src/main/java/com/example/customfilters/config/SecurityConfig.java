package com.example.customfilters.config;

import com.example.customfilters.filters.AuthenticationLoggingFilter;
import com.example.customfilters.filters.RequestValidationFilter;
import com.example.customfilters.filters.StaticKeyAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {
    @Autowired
    private StaticKeyAuthenticationFilter filter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
        throws Exception{
//        http.addFilterBefore(new RequestValidationFilter(),
//                BasicAuthenticationFilter.class)
//                .addFilterAfter(new AuthenticationLoggingFilter(),
//                        BasicAuthenticationFilter.class)
        http.addFilterAt(filter, BasicAuthenticationFilter.class)
                .authorizeHttpRequests(c -> c.anyRequest().permitAll());

        return http.build();
    }
}
