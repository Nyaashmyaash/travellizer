package com.nyash.travellizer.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.nyash.travellizer.model.entity.ticket.Order;
import com.nyash.travellizer.persistence.ticket.OrderRepository;
import com.nyash.travellizer.persistence.ticket.TicketRepository;
import com.nyash.travellizer.service.ticket.impl.TicketServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TicketServiceImplTest {

    @Spy
    @InjectMocks
    private TicketServiceImpl ticketService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private TicketRepository ticketRepository;

    @Test
    public void cancelReservation_validOrder_orderCancelled() {
        Order order = new Order();
        order.setId(1);
        order.setDueDate(LocalDateTime.now().plusDays(2));

        when(orderRepository.findById(order.getId())).thenReturn(Optional.of(order));
        ticketService.cancelReservation(order.getId(), "test");

        assertTrue(order.isCancelled());
        verify(orderRepository, times(1)).save(order);
    }



}
