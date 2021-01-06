package de.ostfale.sbsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class ProjectConfig {

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        String user = "select username, password, enabled from jdbc_user where username=?";
        String authority = "select username, authority from jdbc_authority where username=?";
        var userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery(user);
        userDetailsManager.setAuthoritiesByUsernameQuery(authority);
        return userDetailsManager;
    }

    // works with default tables (users, authorities)
 /*   @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }*/

    // hardcoded user password
  /*  @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = new User("max", "test1234", "read");
        List<UserDetails> user = List.of(userDetails);
        return new InMemoryUserDetailsService(user);
    }*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
