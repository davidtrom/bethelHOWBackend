package com.bethelhouseofworship.BethelHOW.Controllers;


import com.bethelhouseofworship.BethelHOW.Models.PrayerRequest;
import com.bethelhouseofworship.BethelHOW.Models.Testimonial;
import com.bethelhouseofworship.BethelHOW.Services.PrayerRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prayer-requests")
public class PrayerRequestController {

    @Autowired
    private PrayerRequestService prayerRequestService;

    @PostMapping("/create")
    public ResponseEntity<PrayerRequest> createTestimonial(@RequestBody PrayerRequest request){
        return new ResponseEntity<>(prayerRequestService.addRequest(request), HttpStatus.CREATED);
    }

    @GetMapping("/view-requests")
    public ResponseEntity<Iterable<PrayerRequest>> viewPrayerRequests (){
        return new ResponseEntity<>(prayerRequestService.getAllPrayerRequests(), HttpStatus.CREATED);
    }
}
