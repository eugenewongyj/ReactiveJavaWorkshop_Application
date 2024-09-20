package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class MyController {

    @GetMapping("/demo")
    public Mono<String> greetingMessage() {
        return computeMesssage();
    }

    private Mono<String> computeMesssage() {
        return Mono.just("Hello ").delayElement(Duration.ofSeconds(5));
    }
}
