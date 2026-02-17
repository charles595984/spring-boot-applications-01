package com.skcode.spring_boot_docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello World from Spring Boot + Docker!";
    }

    @GetMapping("/hello")
    public String welcome() {
        return "Welcome to the spring boot with docker hello world!";
    }
}
