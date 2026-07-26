package com.tracker.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.repository.LocationRepository;
import com.tracker.repository.UserRepository;
import com.tracker.util.LocationEvent;
import com.tracker.util.LocationRequest;
import com.tracker.util.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocationService {

    @Autowired
    private final LocationRepository locationRepo;

    @Autowired
    private final UserRepository userRepo;

public void saveLocation(LocationRequest request) {

    User user = userRepo.findById(request.userId())
            .orElseThrow(() ->
                    new RuntimeException("User not found"));

    LocationEvent event = LocationEvent.builder()
            .user(user)
            .eventTime(LocalDateTime.now())
            .latitude(request.latitude())
            .longitude(request.longitude())
            .speed(request.speed())
            .accuracy(request.accuracy())
            .build();

    locationRepo.save(event);
}
}