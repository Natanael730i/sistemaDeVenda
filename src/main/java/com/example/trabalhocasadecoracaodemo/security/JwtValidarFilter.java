package com.example.trabalhocasadecoracaodemo.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;

public class JwtValidarFilter extends BasicAuthenticationFilter {

    public static final String HEADER_ATTRIBUTE = "authorization";
    public static final String ATTRIBUTE_PREFIX = "bearer ";

    public JwtValidarFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String attribute = request.getHeader(HEADER_ATTRIBUTE);

        if (attribute == null || !attribute.startsWith(ATTRIBUTE_PREFIX)){
            chain.doFilter(request, response);
            return ;
        }
//        if (!attribute.startsWith(ATTRIBUTE_PREFIX)) {
//            chain.doFilter(request, response);
//            return;
//        }

        String token = attribute.replace(ATTRIBUTE_PREFIX, "");

        UsernamePasswordAuthenticationToken authenticationToken = getPasswordAuthenticationToken(token);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);

    }

    private UsernamePasswordAuthenticationToken getPasswordAuthenticationToken(String token){
        String usuario = JWT.require(Algorithm.HMAC512(JwtAutenticarFilter.TOKEN_SENHA))
                .build()
                .verify(token)
                .getSubject();

        if (usuario == null){
            return null;
        }
        return new UsernamePasswordAuthenticationToken(usuario, null, new ArrayList<>());
    }

}
