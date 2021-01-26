package de.ostfale.sbexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/a")
    public String postEndpointA() {
        return "POST - a : Works!";
    }

    @GetMapping("/a")
    public String getEndpointA() {
        return "GET - a : Works!";
    }

    @GetMapping("/a/b")
    public String getEndpointB() {
        return "GET - a/b : Works!";
    }

    @GetMapping("/a/b/c")
    public String getEndpointC() {
        return "GET - a/b/c : Works!";
    }

    @GetMapping("/product/{code}")
    public String productCode(@PathVariable String code) {
        return code;
    }
}
