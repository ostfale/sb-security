package de.ostfale.sbsecurity.service;

import de.ostfale.sbsecurity.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final UserService userService;

    public Bootstrap(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        final User danielle = new User("Danielle", "12345");
        final User max = new User("Max", "test321");
        userService.addUser(danielle);
        userService.addUser(max);
        userService.auth(new User("Danielle", "12345"));
        userService.auth(new User("Max", "test321"));
    }
}
