package de.ostfale.sbexample.util;

import de.ostfale.sbexample.domain.*;
import de.ostfale.sbexample.repositories.AuthorityRepository;
import de.ostfale.sbexample.repositories.ProductRepository;
import de.ostfale.sbexample.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final AuthorityRepository authorityRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public Bootstrap(AuthorityRepository authorityRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.authorityRepository = authorityRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        User john = new User();
        john.setUsername("john");
        john.setAlgorithm(EncryptionAlgorithm.BCRYPT);
        john.setPassword("$2y$10$8NzE.rs54rxgt4ON7NRk0OzlRgDustYtDbvoD80nno0WLfaMYFLcS");
        userRepository.save(john);

        Authority readAuthority = new Authority();
        readAuthority.setName("READ");
        readAuthority.setUser(john);
        authorityRepository.save(readAuthority);

        Authority writeAuthority = new Authority();
        writeAuthority.setName("WRITE");
        writeAuthority.setUser(john);
        authorityRepository.save(writeAuthority);

        john.getAuthorities().add(readAuthority);
        john.getAuthorities().add(writeAuthority);
        userRepository.save(john);

        Product product = new Product();
        product.setName("Book");
        product.setCurrency(Currency.EUR);
        product.setPrice(15.0);
        productRepository.save(product);
    }
}
