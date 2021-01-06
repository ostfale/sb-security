package de.ostfale.sbsecurity.jdbcservice;

import org.springframework.data.repository.CrudRepository;

public interface JdbcUserRepository extends CrudRepository<JdbcUser,Long> {
}
