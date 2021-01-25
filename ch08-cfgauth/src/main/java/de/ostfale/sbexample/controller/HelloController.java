package de.ostfale.sbexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello matcher...";
    }

    @GetMapping("/ciao")
    public String ciao() {
        return "Ciao matcher...";
    }

    @GetMapping("/hola")
    public String hola() {
        return "Hola matcher...";
    }
}
