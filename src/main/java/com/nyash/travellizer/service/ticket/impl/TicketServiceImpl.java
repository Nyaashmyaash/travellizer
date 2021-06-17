package com.nyash.travellizer.service.ticket.impl;

import com.nyash.travellizer.model.entity.ticket.Order;
import com.nyash.travellizer.model.entity.ticket.Ticket;
import com.nyash.travellizer.service.ticket.TicketService;

import java.util.List;

public class TicketServiceImpl implements TicketService {
    @Override
    public List<Ticket> findTickets(String tripId) {
        return null;
    }

    @Override
    public List<Order> findReservations(String tripId) {
        return null;
    }

    @Override
    public void makeReservation(Order order) {

    }

    @Override
    public void cancelReservation(int orderId, String reason) {

    }

    @Override
    public void completeReservation(int orderId) {

    }

    @Override
    public Ticket buyTicket(String tripId, String clientName) {
        return null;
    }

    @Override
    public List<Order> findOrders() {
        return null;
    }

    @Override
    public List<Order> findOrders(String userId) {
        return null;
    }
}
