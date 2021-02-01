package de.ostfale.sbsecurity.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloCsrfController {

    // request should check for CSRF token
    @PostMapping("hellocsrf")
    public String postHello() {
        return "POST Hello!";
    }

    // request should not check for CSRF token
    @PostMapping("ciaocsrf")
    public String postCiao() {
        return "POST Ciao!";
    }
}
