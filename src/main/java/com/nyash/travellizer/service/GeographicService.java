package com.nyash.travellizer.service;

import com.nyash.travellizer.common.model.search.criteria.range.RangeCriteria;
import com.nyash.travellizer.model.entity.geography.City;
import com.nyash.travellizer.model.entity.geography.Station;
import com.nyash.travellizer.model.entity.geography.search.criteria.StationCriteria;

import java.util.List;
import java.util.Optional;

/**
 * Entry point to perform operations over geographic entities
 *
 * @author Nyash
 */
public interface GeographicService {

    /**
     * Returns list of existing cities
     *
     * @return
     */
    List<City> findCities();

    /**
     * Returns city with specified identifier. If no city is found then empty optional is
     * returned
     *
     * @param id
     * @return
     */
    Optional<City> findCityById(int id);

    /**
     * Returns all the stations that match specified criteria
     *
     * @param criteria
     * @param rangeCriteria
     * @return
     */
    List<Station> searchStations(StationCriteria stationCriteria, RangeCriteria rangeCriteria);

    /**
     * Returns station with specified identifier. If no station is found then empty optional is
     * returned
     *
     * @param id
     * @return
     */

    Optional<Station> findStationById(int id);

    /**
     * Saves(creates or modifies) specified city instance
     * @param station
     */
    void saveStation(Station station);

    /**
     * Saves specified city instance
     *
     * @param city
     */
    void saveCity(City city);

    /**
     * Removes all the cities
     */
    void deleteCities();

    /**
     * Saves all specified city instances
     * @param cities
     */
    void saveCities(List<City> cities);

    /**
     * Delete city with specified identifier
     * @param cityId
     */
    void deleteCity(int cityId);
}
