package com.nyash.travellizer.model.entity;

import com.nyash.travellizer.model.entity.geography.City;
import com.nyash.travellizer.model.entity.geography.Station;
import com.nyash.travellizer.model.entity.geography.TransportType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CityTest {
    private City city;

    @BeforeEach
    void setup() {
        city = new City("Moscow");
    }

    @Nested
    @DisplayName("Checks addStation method")
    class AddStationTest {
        @Test
        void successIfValidStation(){
            Station station = city.addStation(TransportType.ROADWAY);

            assertTrue(containsStation(city, station));
            assertEquals(city, station.getCity());
        }
    }

    private boolean containsStation(City city, Station station) {
        return city.getStations().contains(station);
    }
}
