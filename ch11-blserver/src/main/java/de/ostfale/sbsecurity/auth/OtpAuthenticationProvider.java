package de.ostfale.sbsecurity.auth;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class OtpAuthenticationProvider implements AuthenticationProvider {

    private final AuthenticationServerProxy proxy;

    public OtpAuthenticationProvider(AuthenticationServerProxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String code = String.valueOf(authentication.getCredentials());

        if (proxy.sentOTP(username, code)) {
            return new OTPAuthentication(username, code);
        } else {
            throw new BadCredentialsException("Bad credentials!");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return OTPAuthentication.class.isAssignableFrom(aClass);
    }
}
