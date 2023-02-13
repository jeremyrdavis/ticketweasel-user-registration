package com.ticketweasel.users;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {

    @Test
    public void testInstantiatingOrderFromTickets() {

        Order order = Order.of(new ArrayList<Ticket>() {{
            add(new Ticket());
            add(new Ticket());
        }}, 100.00);

        assertEquals(2, order.getTickets().size());
        assertEquals(100.00, order.getOrderTotal());
    }
}
