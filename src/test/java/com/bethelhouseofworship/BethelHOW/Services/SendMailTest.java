package com.bethelhouseofworship.BethelHOW.Services;

import com.bethelhouseofworship.BethelHOW.Models.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SendMailTest {
    private Contact testContact;

    @BeforeEach
    void setUp() {
        testContact = new Contact(3L, "Manju", "Goyal", "manju@gmail.com", "614-879-3345", "Dallas", "TX", "USA", "I want to know more about your ministry.");
    }

    @Test
    void sendMessage() {
        Assertions.assertEquals(true, SendMail.sendMessage(testContact));
    }
}