package com.bethelhouseofworship.BethelHOW.Models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


class PrayerRequestTest {
    private PrayerRequest prayerRequestTest;
    private LocalDate creationDate = LocalDate.of(2020, 9, 19);

    @BeforeEach
    void setUp() {
        prayerRequestTest = new PrayerRequest(3L, "Simon", "Peter", "Jerusalem", "Jerusalem", "Israel", "Please pray for my son", creationDate);
    }

    @Test
    void getId() {
        Assertions.assertEquals(3L, prayerRequestTest.getId());
    }

    @Test
    void setId() {
        prayerRequestTest.setId(9L);
        Assertions.assertEquals(9L, prayerRequestTest.getId());
    }

    @Test
    void getFirstName() {
        Assertions.assertEquals("Simon", prayerRequestTest.getFirstName());
    }

    @Test
    void setFirstName() {
        prayerRequestTest.setFirstName("Michael");
        Assertions.assertEquals("Michael", prayerRequestTest.getFirstName());
    }

    @Test
    void getLastName() {
        Assertions.assertEquals("Peter", prayerRequestTest.getLastName());
    }

    @Test
    void setLastName() {
        prayerRequestTest.setLastName("Archangel");
        Assertions.assertEquals("Archangel", prayerRequestTest.getLastName());
    }

    @Test
    void getLocationCity() {
        Assertions.assertEquals("Jerusalem", prayerRequestTest.getLocationCity());
    }

    @Test
    void setLocationCity() {
        prayerRequestTest.setLocationCity("Wilmington");
        Assertions.assertEquals("Wilmington", prayerRequestTest.getLocationCity());
    }

    @Test
    void getLocationState() {
        Assertions.assertEquals("Jerusalem", prayerRequestTest.getLocationState());
    }

    @Test
    void setLocationState() {
        prayerRequestTest.setLocationState("DE");
        Assertions.assertEquals("DE", prayerRequestTest.getLocationState());
    }

    @Test
    void getLocationCountry() {
        Assertions.assertEquals("Israel", prayerRequestTest.getLocationCountry());
    }

    @Test
    void setLocationCountry() {
        prayerRequestTest.setLocationCountry("USA");
        Assertions.assertEquals("USA", prayerRequestTest.getLocationCountry());
    }

    @Test
    void getPrayerRequest() {
        Assertions.assertEquals("Please pray for my son", prayerRequestTest.getPrayerRequest());
    }

    @Test
    void setPrayerRequestTest() {
        prayerRequestTest.setPrayerRequest("Pray for my house during the hurricane");
        Assertions.assertEquals("Pray for my house during the hurricane", prayerRequestTest.getPrayerRequest());
    }

    @Test
    void getCreationDate() {
        Assertions.assertEquals(creationDate, prayerRequestTest.getCreationDate());
    }

    @Test
    void setCreationDate() {
        prayerRequestTest.setCreationDate(LocalDate.of(2020, 7, 8));
        Assertions.assertEquals(LocalDate.of(2020, 7, 8), prayerRequestTest.getCreationDate());
    }
}