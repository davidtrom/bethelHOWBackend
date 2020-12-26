package com.bethelhouseofworship.BethelHOW.Controllers;

import com.bethelhouseofworship.BethelHOW.Models.PrayerRequest;
import com.bethelhouseofworship.BethelHOW.Models.Testimonial;
import com.bethelhouseofworship.BethelHOW.Services.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/testimonials")
public class TestimonialController {

    @Autowired
    private TestimonialService testimonialService;

    @PostMapping("/create")
    public ResponseEntity <Boolean> createTestimonial(@RequestBody Testimonial testimonial){
        return new ResponseEntity<>(testimonialService.addTestimonial(testimonial), HttpStatus.CREATED);
    }

    @GetMapping("/view-approved")
    public ResponseEntity <Iterable<Testimonial>> getApprovedTestimonials(){
        return new ResponseEntity<>(testimonialService.getAllApprovedTestimonials(), HttpStatus.OK);
    }

    @GetMapping("/view-denied")
    public ResponseEntity <Iterable<Testimonial>> getDeniedTestimonials(){
        return new ResponseEntity<>(testimonialService.getAllDeniedTestimonials(), HttpStatus.OK);
    }

    @GetMapping("/view-pending")
    public ResponseEntity <Iterable<Testimonial>> getPendingTestimonials(){
        return new ResponseEntity<>(testimonialService.getAllPendingTestimonials(), HttpStatus.OK);
    }

    @DeleteMapping("/{testimonialId}/delete-testimonial")
    public ResponseEntity<Boolean> viewPrayerRequests (@PathVariable Long testimonialId){
        return new ResponseEntity<>(testimonialService.deleteTestimonial(testimonialId), HttpStatus.OK);
    }

    @PutMapping("/{id}/approve-testimonial")
    public ResponseEntity<Testimonial> approveTestimonial(@PathVariable Long id){
        return new ResponseEntity<>(testimonialService.approveTestimonial(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/deny-testimonial")
    public ResponseEntity<Testimonial> denyTestimonial(@PathVariable Long id){
        return new ResponseEntity<>(testimonialService.denyTestimonial(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/pending-testimonial")
    public ResponseEntity<Testimonial> pendingTestimonial(@PathVariable Long id){
        return new ResponseEntity<>(testimonialService.pendingRequest(id), HttpStatus.OK);
    }

    @PutMapping("/approve-all")
    public ResponseEntity<Boolean> pendingTestimonial(){
        return new ResponseEntity<>(testimonialService.approveAllTestimonials(), HttpStatus.OK);
    }

    @DeleteMapping("/delete-denied")
    public ResponseEntity<Boolean> deleteDeniedTestimonials(){
        return new ResponseEntity<>(testimonialService.deleteDeniedTestimonials(), HttpStatus.OK);
    }

    @DeleteMapping("/remove-outdated")
    public ResponseEntity<Boolean> removeOutdatedTestimonials(){
        return new ResponseEntity<>(testimonialService.removeOutdatedTestimonials(), HttpStatus.OK);
    }
}
