package com.example.customfilters.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class StaticKeyAuthenticationFilter implements Filter {
    @Value("${auth.key}")
    private String authorizationKey;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var httpRequest=(HttpServletRequest)servletRequest;
        var httpResponse=(HttpServletResponse)servletResponse;
        String authentication=
                httpRequest.getHeader("Authorization");
        if(authorizationKey.equals(authentication)){
            filterChain.doFilter(servletRequest,servletResponse);
        }
        else {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
