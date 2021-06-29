package com.nyash.travellizer.service.trip;

import com.nyash.travellizer.model.entity.trip.Route;
import com.nyash.travellizer.model.entity.trip.Trip;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TripService {

    /**
     * Returns list of existing routes between these two stations
     *
     * @param start
     * @param destination
     * @return
     */
    List<Route> findRoutes(String start, String destination);

    /**
     * Returns route with specified identifier. If no route is found then empty
     * optional is returned
     *
     * @param id
     * @return
     */
    Optional<Route> findRouteById(int id);

    /**
     * Saves specified route instance
     *
     * @param route
     */
    void saveRoute(Route route);

    /**
     * Delete route with specified identifier
     *
     * @param routeId
     */
    void deleteRoute(int routeId);

    /**
     * Returns list of existing trips for the specified route
     *
     * @return
     */
    List<Trip> findTrips(int routeId);

    /**
     * Returns route with specified identifier. If no route is found then empty
     * optional is returned
     *
     * @param id
     * @return
     */
    Optional<Trip> findTripById(int id);

    /**
     * Saves specified trip instance
     *
     * @param trip
     */
    void saveTrip(Trip trip);

    /**
     * Delete trip with specified identifier
     *
     * @param tripId
     */
    void deleteTrip(int tripId);

    /**
     * Returns true if trip with such route identifier and trip date already exists
     * @param routeId
     * @param date
     * @return
     */
    Trip findTrip(int routeId, LocalDate date);

    /**
     * Saves new trip based on given route identifier and trip date
     * @param routeId
     * @param date
     * @return
     */

    Trip saveTrip(int routeId, LocalDate date);

}
