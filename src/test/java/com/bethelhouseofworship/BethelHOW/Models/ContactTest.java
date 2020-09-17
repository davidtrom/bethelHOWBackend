package com.bethelhouseofworship.BethelHOW.Models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactTest {
    private Contact contactTest;

    @BeforeEach
    void setUp() {
        contactTest = new Contact(2L, "John", "Little", "little@yahoo.com", "302-650-9980", "Dover", "DE", "USA", "Can you help me ship aid to Africa");
    }

    @Test
    void getId() {
        Assertions.assertEquals(2L, contactTest.getId());
    }

    @Test
    void setId() {
        contactTest.setId(5L);
        Assertions.assertEquals(5L, contactTest.getId());
    }

    @Test
    void getFirstName() {
        Assertions.assertEquals("John", contactTest.getFirstName());
    }

    @Test
    void setFirstName() {
        contactTest.setFirstName("David");
        Assertions.assertEquals("David", contactTest.getFirstName());
    }

    @Test
    void getLastName() {
        Assertions.assertEquals("Little", contactTest.getLastName());
    }

    @Test
    void setLastName() {
        contactTest.setLastName("Johnston");
        Assertions.assertEquals("Johnston", contactTest.getLastName());
    }

    @Test
    void getEmail() {
        Assertions.assertEquals("little@yahoo.com", contactTest.getEmail());
    }

    @Test
    void setEmail() {
        contactTest.setEmail("littleJohn@hotmail.com");
        Assertions.assertEquals("littleJohn@hotmail.com", contactTest.getEmail());
    }

    @Test
    void getPhoneNum() {
        Assertions.assertEquals("302-650-9980", contactTest.getPhoneNum());
    }

    @Test
    void setPhoneNum() {
        contactTest.setPhoneNum("610-225-9876");
        Assertions.assertEquals("610-225-9876", contactTest.getPhoneNum());
    }

    @Test
    void getCity() {
        Assertions.assertEquals("Dover", contactTest.getCity());
    }

    @Test
    void setCity() {
        contactTest.setCity("Wilmington");
        Assertions.assertEquals("Wilmington", contactTest.getCity());
    }

    @Test
    void getState() {
        Assertions.assertEquals("DE", contactTest.getState());
    }

    @Test
    void setState() {
        contactTest.setState("PA");
        Assertions.assertEquals("PA", contactTest.getState());
    }

    @Test
    void getCountry() {
        Assertions.assertEquals("USA", contactTest.getCountry());
    }

    @Test
    void setCountry() {
        contactTest.setCountry("Nigeria");
        Assertions.assertEquals("Nigeria", contactTest.getCountry());
    }

    @Test
    void getMessage() {
        Assertions.assertEquals("Can you help me ship aid to Africa", contactTest.getMessage());
    }

    @Test
    void setMessage() {
        contactTest.setMessage("We have a container box ready to ship to Africa");
        Assertions.assertEquals("We have a container box ready to ship to Africa", contactTest.getMessage());
    }
}