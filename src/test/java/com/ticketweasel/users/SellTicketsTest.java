package com.ticketweasel.users;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SellTicketsTest {

    @Test
    public void testSellingTickets() {

        User user = new User("lemmy@motorhead.com", "Lemmy", "Kilminster");
        user.addTickets(new ArrayList(){{
            add(new Ticket());
            add(new Ticket());
        }});

        assertEquals(2, user.getTickets().size());

    }
}
