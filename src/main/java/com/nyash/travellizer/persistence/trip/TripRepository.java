package com.nyash.travellizer.persistence.trip;

import com.nyash.travellizer.model.entity.trip.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Integer> {
}
