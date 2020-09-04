package com.bethelhouseofworship.BethelHOW.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNum;
    private String city;
    private String state;
    private String country;
    private String message;

    public Contact() {}

    public Contact(Long id, String firstName, String lastName, String email, String phoneNum, String city, String state, String country, String message) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.city = city;
        this.state = state;
        this.country = country;
        this.message = message;
    }
}

