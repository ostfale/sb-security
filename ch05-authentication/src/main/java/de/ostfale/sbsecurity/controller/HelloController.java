package de.ostfale.sbsecurity.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.concurrent.DelegatingSecurityContextCallable;
import org.springframework.security.concurrent.DelegatingSecurityContextExecutorService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    @GetMapping("/ciao")
    public String ciao() throws Exception {
        Callable<String> task = () -> {
            SecurityContext securityContext = SecurityContextHolder.getContext();
            return securityContext.getAuthentication().getName();
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            // needs DelegatingSecurityContextCallable to provide Context otherwise NPE
            var contextTask = new DelegatingSecurityContextCallable<>(task);
            return "Ciao, " + executorService.submit(contextTask).get() + "!";
        } finally {
            executorService.shutdown();
        }
    }

    @GetMapping("/hola")
    public String hola() throws ExecutionException, InterruptedException {
        Callable<String> task = () -> {
            SecurityContext securityContext = SecurityContextHolder.getContext();
            return securityContext.getAuthentication().getName();
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService = new DelegatingSecurityContextExecutorService(executorService);
        try {
            return "Hola " + executorService.submit(task).get() + "!";
        } finally {
            executorService.shutdown();
        }
    }
}
