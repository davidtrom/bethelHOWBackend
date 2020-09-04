package com.bethelhouseofworship.BethelHOW.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Locale;

@Entity
public class Testimonial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String firstName;
    private String lastName;
    private String locationCity;
    private String locationState;
    private String locationCountry;
    private String testimonial;

    public Testimonial() {}

    public Testimonial(Long id, String firstName, String lastName, String locationCity, String locationState, String locationCountry, String testimonial) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.locationCity = locationCity;
        this.locationState = locationState;
        this.locationCountry = locationCountry;
        this.testimonial = testimonial;
    }
}
