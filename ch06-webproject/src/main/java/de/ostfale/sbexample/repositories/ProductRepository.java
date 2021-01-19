package de.ostfale.sbexample.repositories;

import de.ostfale.sbexample.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer> {
}
