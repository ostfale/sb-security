package de.ostfale.sbsecurity.repository;

import de.ostfale.sbsecurity.domain.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.UUID;

public class CustomCsrfTokenRepository implements CsrfTokenRepository {

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public CsrfToken generateToken(HttpServletRequest request) {
        String uuid = UUID.randomUUID().toString();
        return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", uuid);
    }

    @Override
    public void saveToken(CsrfToken csrfToken, HttpServletRequest request, HttpServletResponse response) {
        String identifier = request.getHeader("X-IDENTIFIER");
        final Optional<Token> tokenByIdentifier = tokenRepository.findTokenByIdentifier(identifier);

        if (tokenByIdentifier.isPresent()) {
            Token foundToken = tokenByIdentifier.get();
            foundToken.setToken(csrfToken.getToken());
        } else {
            Token aToken = new Token();
            aToken.setToken(csrfToken.getToken());
            aToken.setIdentifier(identifier);
            tokenRepository.save(aToken);
        }
    }

    @Override
    public CsrfToken loadToken(HttpServletRequest request) {
        String identifier = request.getHeader("X-IDENTIFIER");
        final Optional<Token> tokenByIdentifier = tokenRepository.findTokenByIdentifier(identifier);

        if (tokenByIdentifier.isPresent()) {
            Token foundToken = tokenByIdentifier.get();
            return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", foundToken.getToken());
        }

        return null;
    }
}
