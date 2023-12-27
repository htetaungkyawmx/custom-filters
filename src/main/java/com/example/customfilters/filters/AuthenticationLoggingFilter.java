package com.example.customfilters.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class AuthenticationLoggingFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        var httpRequest =(HttpServletRequest)servletRequest;
        var requestId = httpRequest.getHeader("Request-Id");
        logger.info("Successfully authenticated request with id "+ requestId);

        filterChain.doFilter(servletRequest,servletResponse);
    }
}
