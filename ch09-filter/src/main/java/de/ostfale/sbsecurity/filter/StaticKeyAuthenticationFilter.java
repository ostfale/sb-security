package de.ostfale.sbsecurity.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@Component
public class StaticKeyAuthenticationFilter implements Filter {

    private final Logger logger = Logger.getLogger(StaticKeyAuthenticationFilter.class.getName());

    @Value("${authorization.key}")
    private String authorizationKey;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        var httpRequest = (HttpServletRequest) request;
        var httpResponse = (HttpServletResponse) response;

        String authentication = httpRequest.getHeader("Authentication");
        logger.info("Use authorization key: " + authentication);
        if (authorizationKey.equals(authentication)) {
            filterChain.doFilter(request, response);
        } else {
            logger.warning("Error for Authentication!");
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
