package com.ilyas.api_bancaire.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService  jwtService;
    private final CustomerDetailsService customerDetailsService;

    public JwtAuthenticationFilter(JwtService jwtService, CustomerDetailsService customerDetailsService) {
        this.jwtService = jwtService;
        this.customerDetailsService = customerDetailsService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);

        String email = jwtService.extractUsername(token);

        UserDetails userDetails =
                customerDetailsService.loadUserByUsername(email);

        if (jwtService.validateToken(token, userDetails)) {

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );
            // sert enregistre l utilisateur authentifier dnas Context
            SecurityContextHolder.getContext()
                    .setAuthentication(authentication);
        }
      // j ai fini mon travail  laisser passer la requete et elle va aller jusqu au controlleur
        // sinon elle n ira jamais au controleur
        filterChain.doFilter(request, response);
    }
}
