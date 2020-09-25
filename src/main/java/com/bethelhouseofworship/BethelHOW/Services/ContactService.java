package com.bethelhouseofworship.BethelHOW.Services;

import com.bethelhouseofworship.BethelHOW.Models.Contact;
import com.bethelhouseofworship.BethelHOW.Repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Boolean sendEmail (Contact contact){
        Boolean emailSent = SendMail.sendMessage(contact);
        contactRepository.save(contact);
        return emailSent;
    }
}
