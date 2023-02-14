package com.ticketweasel.users;

import com.ticketweasel.users.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TicketTest {

    @Test
    public void testTickets() {

        User user = new User("george@beatles.com", "George", "Harrison");
        Ticket ticket = new Ticket();
        ticket.setOwner(user);

        assertFalse(ticket.forSale);
        assertEquals(user, ticket.owner);
    }
}
