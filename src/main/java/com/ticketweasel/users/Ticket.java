package com.ticketweasel.users;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Ticket extends PanacheEntity {

    @ManyToOne
    @JoinColumn(name = "owner_id")
    protected User owner;

    boolean forSale;

    public Ticket() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        return Objects.equals(id, ticket.id);
    }

    public boolean isForSale() {

        return forSale;
    }

    @Override
    public int hashCode() {
        return owner != null ? owner.hashCode() : 0;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

}
