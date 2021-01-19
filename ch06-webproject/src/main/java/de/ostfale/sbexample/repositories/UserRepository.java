package de.ostfale.sbexample.repositories;

import de.ostfale.sbexample.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findUserByUsername(String userName);
}
