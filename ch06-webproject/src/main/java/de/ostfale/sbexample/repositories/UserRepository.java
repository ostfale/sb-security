package de.ostfale.sbexample.repositories;

import de.ostfale.sbexample.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
