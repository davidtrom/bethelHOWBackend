package com.bethelhouseofworship.BethelHOW.Controllers;

import com.bethelhouseofworship.BethelHOW.Models.Contact;
import com.bethelhouseofworship.BethelHOW.Services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/send-email")
    public ResponseEntity<Boolean> sendEmail(@RequestBody Contact contact){
        return new ResponseEntity<>(contactService.sendEmail(contact), HttpStatus.OK);
    }

    @PutMapping("/clean-contacts")
    public ResponseEntity<Boolean> removeOutdatedContacts (){
        return new ResponseEntity<>(contactService.removeOutdatedContacts(), HttpStatus.OK);
    }


}
