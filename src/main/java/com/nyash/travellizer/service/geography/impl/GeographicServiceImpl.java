package com.nyash.travellizer.service.geography.impl;

import com.nyash.travellizer.common.model.search.criteria.range.RangeCriteria;
import com.nyash.travellizer.model.entity.geography.City;
import com.nyash.travellizer.model.entity.geography.Station;
import com.nyash.travellizer.model.entity.geography.search.criteria.StationCriteria;
import com.nyash.travellizer.service.geography.GeographicService;

import java.util.List;
import java.util.Optional;

public class GeographicServiceImpl implements GeographicService {
    @Override
    public List<City> findCities() {
        return null;
    }

    @Override
    public Optional<City> findCityById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Station> searchStations(StationCriteria stationCriteria, RangeCriteria rangeCriteria) {
        return null;
    }

    @Override
    public Optional<Station> findStationById(int id) {
        return Optional.empty();
    }

    @Override
    public void saveStation(Station station) {

    }

    @Override
    public void saveCity(City city) {

    }

    @Override
    public void deleteCities() {

    }

    @Override
    public void saveCities(List<City> cities) {

    }

    @Override
    public void deleteCity(int cityId) {

    }
}
