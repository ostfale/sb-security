package de.ostfale.sbsecurity.jdbcservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final JdbcUserRepository jdbcUserRepository;
    private final JdbcAuthorityRepository jdbcAuthorityRepository;

    public BootstrapData(JdbcUserRepository jdbcUserRepository, JdbcAuthorityRepository jdbcAuthorityRepository) {
        this.jdbcUserRepository = jdbcUserRepository;
        this.jdbcAuthorityRepository = jdbcAuthorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        JdbcUser user = new JdbcUser("john", "test123", 1);
        JdbcAuthority authority = new JdbcAuthority("john", "write");
        jdbcUserRepository.save(user);
        jdbcAuthorityRepository.save(authority);
    }
}
