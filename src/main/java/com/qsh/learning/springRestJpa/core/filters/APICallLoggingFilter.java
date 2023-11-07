package com.qsh.learning.springRestJpa.core.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class APICallLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        logger.info("Request begin");
        logger.info(String.format("Request URI    : %s", request.getRequestURI()));
        logger.info(String.format("Method         : %s", request.getMethod()));
        logger.info("Request end");

        filterChain.doFilter(request, response);

        logger.info("Response begin");
        logger.info(String.format("Status    : %s", response.getStatus()));
        logger.info("Response end");
    }
}
