package de.ostfale.sbsecurity.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        return "Hello " + authentication.getName() + " from SecurityContext!";
    }

    @GetMapping("/helloInject")
    public String helloInject(Authentication authentication) {
        return "Hello " + authentication.getName() + " with injected SecurityContext!";
    }

    @GetMapping("/bye")
    @Async
    public void bye() {
        SecurityContext context = SecurityContextHolder.getContext();
        String username = context.getAuthentication().getName();
        System.out.println("Username from async context: " + username);
    }
}
