package com.bethelhouseofworship.BethelHOW.Models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


class TestimonialTest {
    private Testimonial testimonialTest;
    private LocalDate creationDate = LocalDate.of(1982, 7, 8);

    @BeforeEach
    void setUp() {
        testimonialTest = new Testimonial(3L, "Simon", "Peter", "Jerusalem", "Jerusalem", "Israel", "God appeared to me in a burning bush", creationDate);
    }

    @Test
    void getId() {
        Assertions.assertEquals(3L, testimonialTest.getId());
    }

    @Test
    void setId() {
        testimonialTest.setId(9L);
        Assertions.assertEquals(9L, testimonialTest.getId());
    }

    @Test
    void getFirstName() {
        Assertions.assertEquals("Simon", testimonialTest.getFirstName());
    }

    @Test
    void setFirstName() {
        testimonialTest.setFirstName("Michael");
        Assertions.assertEquals("Michael", testimonialTest.getFirstName());
    }

    @Test
    void getLastName() {
        Assertions.assertEquals("Peter", testimonialTest.getLastName());
    }

    @Test
    void setLastName() {
        testimonialTest.setLastName("Archangel");
        Assertions.assertEquals("Archangel", testimonialTest.getLastName());
    }

    @Test
    void getLocationCity() {
        Assertions.assertEquals("Jerusalem", testimonialTest.getLocationCity());
    }

    @Test
    void setLocationCity() {
        testimonialTest.setLocationCity("Wilmington");
        Assertions.assertEquals("Wilmington", testimonialTest.getLocationCity());
    }

    @Test
    void getLocationState() {
        Assertions.assertEquals("Jerusalem", testimonialTest.getLocationState());
    }

    @Test
    void setLocationState() {
        testimonialTest.setLocationState("DE");
        Assertions.assertEquals("DE", testimonialTest.getLocationState());
    }

    @Test
    void getLocationCountry() {
        Assertions.assertEquals("Israel", testimonialTest.getLocationCountry());
    }

    @Test
    void setLocationCountry() {
        testimonialTest.setLocationCountry("USA");
        Assertions.assertEquals("USA", testimonialTest.getLocationCountry());
    }

    @Test
    void getTestimonial() {
        Assertions.assertEquals("God appeared to me in a burning bush", testimonialTest.getTestimonial());
    }

    @Test
    void setTestimonial() {
        testimonialTest.setTestimonial("A tongue of fire fell upon me");
        Assertions.assertEquals("A tongue of fire fell upon me", testimonialTest.getTestimonial());
    }

    @Test
    void getCreationDate() {
        Assertions.assertEquals(LocalDate.of(1982, 7, 8), testimonialTest.getCreationDate());
    }

    @Test
    void setCreationDate() {
        testimonialTest.setCreationDate(LocalDate.of(2020, 7, 8));
        Assertions.assertEquals(LocalDate.of(2020, 7, 8), testimonialTest.getCreationDate());
    }

    @Test
    void getRequestStatus() {
        Assertions.assertEquals(RequestStatus.PENDING, testimonialTest.getRequestStatus());
    }

    @Test
    void setRequestStatus() {
        testimonialTest.setRequestStatus(RequestStatus.DENIED);
        Assertions.assertEquals(RequestStatus.DENIED, testimonialTest.getRequestStatus());
    }
}