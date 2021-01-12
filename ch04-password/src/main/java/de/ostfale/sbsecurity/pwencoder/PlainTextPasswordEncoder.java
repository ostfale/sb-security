package de.ostfale.sbsecurity.pwencoder;

import org.springframework.security.crypto.password.PasswordEncoder;

// Simply return the given password
public class PlainTextPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();  // not changed, just returned
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.equals(encodedPassword);
    }
}
