package com.ticketweasel.users;

import java.util.ArrayList;
import java.util.Collection;

public class Order {

    protected Collection<Ticket> tickets;

    protected double orderTotal;

    public Order(ArrayList<Ticket> tickets, double orderTotal) {
        this.tickets = tickets;
        this.orderTotal = orderTotal;
    }

    public static Order of(ArrayList<Ticket> tickets, double orderTotal) {

        return new Order(tickets, orderTotal);
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public double getOrderTotal() {
        return orderTotal;
    }
}
