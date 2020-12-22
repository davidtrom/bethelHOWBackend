package com.bethelhouseofworship.BethelHOW.Services;

import com.bethelhouseofworship.BethelHOW.Models.Contact;
import com.bethelhouseofworship.BethelHOW.Models.PrayerRequest;
import com.bethelhouseofworship.BethelHOW.Models.Testimonial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SendMailTest {
    private Contact testContact;
    private Testimonial testimonial;
    private PrayerRequest prayerRequestTest;
    private LocalDate creationDate = LocalDate.of(2020, 12, 21);

    @BeforeEach
    void setUp() {
        testContact = new Contact(3L, "Manju", "Goyal", "manju@gmail.com", "614-879-3345", "Dallas", "TX", "USA", "I want to know more about your ministry.");
        testimonial = new Testimonial(8L, "Abraham", "Maldoves", "Paris", "Paris", "France", "God appeared in the Eiffel Tower", LocalDate.of(2020, 3, 13));
        prayerRequestTest = new PrayerRequest(3L, "Simon", "Peter", "Jerusalem", "Jerusalem", "Israel", "Please pray for my son", creationDate);
    }

    @Test
    void sendMessage() {
        Assertions.assertEquals(true, SendMail.sendContactMessage(testContact));
    }

    @Test
    void sendTestimonialMessage() {
        Assertions.assertEquals(true, SendMail.sendNotificationMessage(testimonial));
    }

    @Test
    void sendPrayerRequestMessage() {
        Assertions.assertEquals(true, SendMail.sendNotificationMessage(prayerRequestTest));
    }
}