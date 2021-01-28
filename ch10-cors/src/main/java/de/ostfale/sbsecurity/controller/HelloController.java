package de.ostfale.sbsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String getHello() {
        return "GET Hello from CSRF";
    }

    @PostMapping("/hello")
    public String postHello() {
        return "POST Hello from CSRF";
    }
}
