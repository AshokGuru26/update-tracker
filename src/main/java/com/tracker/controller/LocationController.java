package com.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.service.LocationService;
import com.tracker.util.LocationRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private final LocationService service;

    @PostMapping("/new")
    public ResponseEntity<Void> submitLocation(
            @RequestBody LocationRequest request) {

        service.saveLocation(request);
        return ResponseEntity.accepted().build();
    }
}