package com.tracker.util;

public record LocationRequest(

        Long userId,

        Double latitude,

        Double longitude,

        Double speed,

        Double accuracy
) {
}