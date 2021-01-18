package de.ostfale.sbexample.repositories;

import de.ostfale.sbexample.domain.Authority;
import org.springframework.data.repository.CrudRepository;

public interface AuthorityRepository extends CrudRepository<Authority, Integer> {
}
