package com.ticketweasel.users;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class UsersTest {

    @Test
    public void testListingTicketsForSale() {

        User user = createUserWith2Tickets();
        Ticket ticketOne = (Ticket) user.tickets.toArray()[0];
        Ticket ticketTwo = (Ticket) user.tickets.toArray()[1];

        user.getTickets().forEach(ticket -> {
            assertFalse(ticket.isForSale());
        });

        user.listTickets(new ArrayList<Ticket>(){{
            add(ticketOne);
            add(ticketTwo);
        }});

        user.getTickets().forEach(ticket -> {
            assertTrue(ticket.isForSale());
        });
    }
    @Test
    public void testSellingTickets() {

        User user = createUserWith2Tickets();
        Ticket ticketOne = (Ticket) user.tickets.toArray()[0];
        Ticket ticketTwo = (Ticket) user.tickets.toArray()[1];
        user.sellTickets(Order.of(new ArrayList<Ticket>(){{ add(ticketOne); add(ticketTwo);}}, 200.00));

        assertEquals(0, user.getTickets().size());
    }

    private User createUserWith2Tickets() {
        User user = new User("lemmy@motorhead.com","Lemmy", "Kilminster");
        Ticket ticketOne = new Ticket();
        ticketOne.id = new Random().nextLong();
        Ticket ticketTwo = new Ticket();
        ticketTwo.id = new Random().nextLong();
        user.addTickets(new ArrayList<Ticket>(){{
            add(ticketOne);
            add(ticketTwo);
        }});

        assertEquals(2, user.getTickets().size());

        System.out.println(user);

        return user;
    }

}
