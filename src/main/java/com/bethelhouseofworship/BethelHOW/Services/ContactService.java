package com.bethelhouseofworship.BethelHOW.Services;

import com.bethelhouseofworship.BethelHOW.Models.Contact;
import com.bethelhouseofworship.BethelHOW.Models.PrayerRequest;
import com.bethelhouseofworship.BethelHOW.Repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Boolean sendEmail (Contact contact){
        Boolean emailSent;
        try{
            emailSent = SendMail.sendContactMessage(contact);
            contactRepository.save(contact);
        } catch (Exception e) {
            emailSent = false;
        }
        return emailSent;
    }

    public Boolean removeOutdatedContacts(){
        //Contact Requests deleted after 30 days
        Boolean flag;
        List<Contact> allContactsList = new ArrayList<>();
        Iterable<Contact> getAllRequests = contactRepository.findAll();
        getAllRequests.forEach(allContactsList::add);
        try{
            for (Contact contact: allContactsList){
                long diff = ChronoUnit.DAYS.between(contact.getCreationDate(), LocalDate.now());
                if(diff > 30){
                    contactRepository.delete(contact);
                }
            }
            flag = true;

        } catch(Exception e){
            flag = false;
        }
        return flag;
    }
}
