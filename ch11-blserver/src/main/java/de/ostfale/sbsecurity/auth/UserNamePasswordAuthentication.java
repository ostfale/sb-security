package de.ostfale.sbsecurity.auth;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserNamePasswordAuthentication extends UsernamePasswordAuthenticationToken {

    // instance remain unauthenticated
    public UserNamePasswordAuthentication(Object principal, Object credentials) {
        super(principal, credentials);
    }

    // sets object authenticated
    public UserNamePasswordAuthentication(
            Object principal,
            Object credentials,
            Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
