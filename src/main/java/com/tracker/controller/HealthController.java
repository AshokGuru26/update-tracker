package com.tracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/")
    public String home() {
        return "Application is running";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Application says hello";
    }
}
