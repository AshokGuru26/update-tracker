package com.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.repository.LocationRepository;
import com.tracker.util.LocationEvent;
import com.tracker.util.LocationRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocationService {

    @Autowired
    private final LocationRepository repo;

    public void save(LocationRequest request) {
        LocationEvent event = new LocationEvent(request);
        repo.save(event);
    }
}