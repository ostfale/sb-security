package de.ostfale.sbsecurity.filter;

import org.springframework.security.web.csrf.CsrfToken;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Logger;

public class CsrfTokenLogger implements Filter {

    private final Logger logger = Logger.getLogger(CsrfTokenLogger.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
        logger.info("CSRF Token extracted: " + token.getToken());
        filterChain.doFilter(request, response);
    }
}
