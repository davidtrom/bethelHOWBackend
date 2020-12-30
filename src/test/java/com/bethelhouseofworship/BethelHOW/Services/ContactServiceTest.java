package com.bethelhouseofworship.BethelHOW.Services;

import com.bethelhouseofworship.BethelHOW.Models.Contact;
import com.bethelhouseofworship.BethelHOW.Repositories.ContactRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ContactServiceTest {
    private Contact contact1, contact2, contact3;
    private LocalDate date1 = LocalDate.of(2020, 9, 24);
    private LocalDate date2 = LocalDate.of(2020, 5, 24);
    private LocalDate date3 = LocalDate.of(2020, 12, 24);

    //@Mock
    private ContactRepository contactRepository = mock(ContactRepository.class);

//    @Mock
//    @InjectMocks
    private ContactService contactServiceTest;

    @BeforeEach
    void setUp() {
        contact1 = new Contact(2L, "John", "Little", "little@yahoo.com", "302-650-9980", "Dover", "DE", "USA", "Can you help me ship aid to Africa");
        contact2 = new Contact(3L, "Pete", "Bigmans", "little@yahoo.com", "302-650-9980", "Dover", "DE", "USA", "Can you help me ship aid to Africa");
        contact3 = new Contact(4L, "Laura", "Ingalls", "little@yahoo.com", "302-650-9980", "Dover", "DE", "USA", "Can you help me ship aid to Africa");
        contact1.setCreationDate(date1);
        contact2.setCreationDate(date2);
        contact3.setCreationDate(date3);
        contactServiceTest = new ContactService();
        contactRepository.save(contact1);
        contactRepository.save(contact2);
        contactRepository.save(contact3);
    }

    @Test
    void removeOutdatedContacts() {
//        verify(contactRepository, times(2)).(contactServiceTest.removeOutdatedContacts());
//        verify(contactRepository).save(contact2);
//        verify(contactRepository).save(contact3);
//
//
//        System.out.println(contactRepository.findAll());
//        //when(contactServiceTest.removeOutdatedContacts()).thenReturn(true);
//        //verify(times(1))
//        System.out.println(contact3.getCreationDate());
//        System.out.println(contactRepository.findAll());
//        Assertions.assertEquals(contactRepository.count(), 1);
    }
}