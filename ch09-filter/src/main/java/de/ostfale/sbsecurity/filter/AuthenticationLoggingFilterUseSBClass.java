package de.ostfale.sbsecurity.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Is going to be executed only once and provided SB solution. Casts types already. 
 */
public class AuthenticationLoggingFilterUseSBClass  extends OncePerRequestFilter {

    private final Logger logger = Logger.getLogger(AuthenticationLoggingFilterUseSBClass.class.getName());

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var requestId = request.getHeader("Request-Id");
        logger.info("Successfully authenticated request with id: " + requestId);
        filterChain.doFilter(request, response);
    }
}
