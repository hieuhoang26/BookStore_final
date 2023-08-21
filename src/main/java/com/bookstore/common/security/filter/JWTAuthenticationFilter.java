package com.bookstore.common.security.filter;


import com.bookstore.common.enums.Uri;
import com.bookstore.common.security.service.TokenAuthenticationService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// OncePerRequestFilter is executed only once for a given request
public class JWTAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = new TokenAuthenticationService().authenticateRequestByToken(request);
        // Set into SecurityContextHolder to Authorization;
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Goto EndPoint;
        filterChain.doFilter(request,response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String requestUri = request.getRequestURI();
        return requestUri.startsWith("/swagger-ui")
                || requestUri.startsWith("/swagger-resources")
                || requestUri.startsWith("/v3/api-docs")
                || requestUri.startsWith("/auth/**")
                || requestUri.startsWith(Uri.USER_LOGIN)
                || requestUri.startsWith(Uri.USER_SIGNUP);

    }
}
