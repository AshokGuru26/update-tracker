package com.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.service.LocationService;
import com.tracker.util.LocationRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/locations")
public class LocationController {

    @Autowired
    private final LocationService service;

    @PostMapping
    public ResponseEntity<Void> submitLocation(
            @RequestBody LocationRequest request) {

        service.save(request);

        return ResponseEntity.accepted().build();
    }
    @GetMapping("/hello")
    public String Hello() {
        return "Hello";
    }
}