package com.tracker.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tracker.util.LocationRequest;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class LocationRepository {

    private final JdbcTemplate jdbcTemplate;

    public void save(LocationRequest request) {

        jdbcTemplate.update("""
            INSERT INTO location_event
            (
                event_time,
                user_id,
                latitude,
                longitude,
                speed,
                accuracy,
            )
            VALUES (NOW(), ?, ?, ?, ?, ?, ?)
            """,
            request.userId(),
            request.latitude(),
            request.longitude(),
            request.speed(),
            request.accuracy()
        );
    }
}