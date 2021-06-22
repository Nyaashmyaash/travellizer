package com.nyash.travellizer.persistence.ticket;

import com.nyash.travellizer.model.entity.ticket.Ticket;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Defines CRUD methods to access Ticket objects in the persistent storage
 *
 * @author Nyash
 *
 */
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    /**
     * Returns all the tickets for given trip
     * @param tripId
     * @return
     */

    List<Ticket>findByTripId(@Param("tripId") String tripId);
}
