package de.ostfale.sbexample.repositories;

import de.ostfale.sbexample.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
