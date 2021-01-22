package de.ostfale.sbexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        var manager = new InMemoryUserDetailsManager();

        var john = User.withUsername("john")
                .password("test1234")
                .authorities("read")
                .build();

        var linda = User.withUsername("linda")
                .password("test4321")
                .authorities("read", "write", "delete")
                .build();

        manager.createUser(john);
        manager.createUser(linda);
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        // version0: simplest http.authorizeRequests().anyRequest().hasAuthority("WRITE");
        // version1: http.authorizeRequests().anyRequest().hasAnyAuthority("READ","WRITE");
        // version2 - more flexible : http.authorizeRequests().anyRequest().access("hasAuthority('WRITE')");

        String expression = "hasAuthority('read') and !hasAuthority('delete')";
        http.authorizeRequests().anyRequest().access(expression);
    }
}
