package com.nyash.travellizer.model.entity.ticket;

import org.junit.jupiter.api.BeforeEach;

public class TicketTest {
    private Ticket ticket;

    @BeforeEach
    void setup(){
        ticket = new Ticket();
        ticket.setId(1);
    }
}
