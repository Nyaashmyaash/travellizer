package com.nyash.travellizer.persistence.geography;

import com.nyash.travellizer.model.entity.geography.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
