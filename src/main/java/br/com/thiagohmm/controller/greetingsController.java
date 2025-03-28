package br.com.thiagohmm.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.thiagohmm.model.Greetings;

@RestController
public class greetingsController {

    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greetings")
    public String greetings(@RequestParam(value = "name", defaultValue = "World") String name) {
        //return new Greetings(counter.incrementAndGet(), String.format(template, name));
       return new Greetings(counter.incrementAndGet(), String.format(TEMPLATE, name)).getContent();
    }
}
