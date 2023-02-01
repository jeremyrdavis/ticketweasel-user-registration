package com.ticketweasel.users;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ticket extends PanacheEntity {


    @ManyToOne
    @JoinColumn(name = "owner_id")
    protected User owner;

    public Ticket() {
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
