package com.nyash.travellizer.model.entity.geography;

import com.nyash.travellizer.model.entity.geography.City;
import com.nyash.travellizer.model.entity.geography.Station;
import com.nyash.travellizer.model.entity.geography.TransportType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        void successIfValidStation() {
            Station station = city.addStation(TransportType.ROADWAY);

            assertTrue(containsStation(city, station));
            assertEquals(city, station.getCity());
        }

//        @Test
//        void throwsExceptionIfNullTransportType() {
//            assertThrows(NullPointerException.class, () -> city.addStation(null));
//        }
    }

    private boolean containsStation(City city, Station station) {
        return city.getStations().contains(station);
    }

    @Nested
    @DisplayName("Checks addStation method")
    class RemoveStationTest {
        @Test
        void success() {
            Station station = city.addStation(TransportType.AIR);
            city.removeStation(station);

            assertTrue(city.getStations().isEmpty());
        }

        @Test
        void throwsExceptionIfStationNull() {
            assertThrows(NullPointerException.class, () -> city.removeStation(null));
        }
    }
}
