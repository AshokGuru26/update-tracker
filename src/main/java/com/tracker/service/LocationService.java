package com.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.repository.LocationRepository;
import com.tracker.util.LocationRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocationService {

    @Autowired
    private final LocationRepository repository;

    public void save(LocationRequest request) {

        repository.save(request);
    }
}