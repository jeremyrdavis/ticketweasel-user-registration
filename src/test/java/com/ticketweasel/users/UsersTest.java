package com.ticketweasel.users;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersTest {

    @Test
    public void testAddingTicketsToSell() {

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

        user.sellTickets(Order.of(new ArrayList<Ticket>(){{ add(ticketOne); add(ticketTwo);}}, 200.00));

        assertEquals(0, user.getTickets().size());
    }
}
