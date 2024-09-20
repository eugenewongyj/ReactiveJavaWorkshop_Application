package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class MyController {

    @GetMapping("/demo")
    public Mono<String> greetingMessage() {
        return computeMesssage()
                .zipWith(getNameFromDB())
                .map(value -> value.getT1() + value.getT2());
    }

    private Mono<String> computeMesssage() {
        return Mono.just("Hello ").delayElement(Duration.ofSeconds(5));
    }

    private Mono<String> getNameFromDB() {
        return Mono.just("Eugene").delayElement(Duration.ofSeconds(5));
    }
}
