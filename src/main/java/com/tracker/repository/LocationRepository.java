package com.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.util.LocationEvent;

@Repository
public interface LocationRepository extends JpaRepository<LocationEvent, Long> {
}