package com.tracker.util;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "location_event")
public class LocationEvent {

    @Id
    private Instant eventTime;

    private Long userId;

    private Double latitude;

    private Double longitude;

    private Double speed;

    private Double accuracy;

    private String source;

}