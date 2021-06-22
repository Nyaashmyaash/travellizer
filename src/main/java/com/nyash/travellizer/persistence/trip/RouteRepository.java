package com.nyash.travellizer.persistence.trip;

import com.nyash.travellizer.model.entity.trip.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Integer> {
}
