package com.adriana.goaltracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Spring merge ✅";
    }

    @GetMapping("/test")
    public String test() {
        return "Endpoint /test merge ✅";
    }
}
