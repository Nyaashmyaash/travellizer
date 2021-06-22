package com.nyash.travellizer.persistence.geography;

import com.nyash.travellizer.model.entity.geography.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Integer> {
}
