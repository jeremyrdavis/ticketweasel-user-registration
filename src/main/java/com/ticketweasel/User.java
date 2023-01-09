package com.ticketweasel;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class User extends PanacheEntity {

    protected String email;

    protected String firstName;

    protected String lastName;

    protected User(final String email, final String firstName, final String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    protected User() {

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
}
