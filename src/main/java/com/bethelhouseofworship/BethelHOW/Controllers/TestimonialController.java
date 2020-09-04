package com.bethelhouseofworship.BethelHOW.Controllers;

import com.bethelhouseofworship.BethelHOW.Models.Testimonial;
import com.bethelhouseofworship.BethelHOW.Services.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testimonials")
public class TestimonialController {

    @Autowired
    private TestimonialService testimonialService;

    @PostMapping("/create")
    public ResponseEntity <Testimonial> createTestimonial(@RequestBody Testimonial testimonial){
        return new ResponseEntity<>(testimonialService.addTestimonial(testimonial), HttpStatus.CREATED);
    }


}
