package com.ticketweasel.users;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class User extends PanacheEntity {

    protected String email;

    protected String firstName;

    protected String lastName;

    @OneToMany
    protected Collection<Ticket> tickets;

    protected User(final String email, final String firstName, final String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    protected User() {

    }

    public void sellTickets(Order order) {

        order.tickets.forEach(ticket -> {
            this.getTickets().remove(ticket);
        });
    }

    public void addTickets(Collection<Ticket> tickets) {
        if (this.tickets == null) {
            this.tickets = new ArrayList<>(tickets.size());
        }
        this.tickets.addAll(tickets);
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", tickets=" + tickets +
                ", id=" + id +
                '}';
    }
}
