package de.ostfale.sbsecurity.config;

import de.ostfale.sbsecurity.inmemservice.InMemoryUserDetailsService;
import de.ostfale.sbsecurity.inmemservice.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class ProjectConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = new User("max", "test1234", "read");
        List<UserDetails> user = List.of(userDetails);
        return new InMemoryUserDetailsService(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
