package com.ndduroc.rocmovies.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController

public class HelloController {

    @GetMapping("/h")
    public String sayHello(@RequestParam String param) {
        return "<h1>hello " + param + "</h1>";
    }
    
}
