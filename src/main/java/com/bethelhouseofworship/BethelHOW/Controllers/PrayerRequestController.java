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

    @GetMapping("/view-approved")
    public ResponseEntity<Iterable<PrayerRequest>> viewApprovedPrayerRequests (){
        return new ResponseEntity<>(prayerRequestService.getAllApprovedPrayerRequests(), HttpStatus.OK);
    }

//
//    @GetMapping("/view-denied")
//    public ResponseEntity<Iterable<PrayerRequest>> viewDeniedPrayerRequests (){
//        return new ResponseEntity<>(prayerRequestService.getAllDeniedPrayerRequests(), HttpStatus.OK);
//    }
//
//    @GetMapping("/view-pending")
//    public ResponseEntity<Iterable<PrayerRequest>> viewPendingPrayerRequests (){
//        return new ResponseEntity<>(prayerRequestService.getAllPendingPrayerRequests(), HttpStatus.OK);
//    }

    @DeleteMapping("/delete-request")
    public ResponseEntity<Boolean> viewPrayerRequests (@PathVariable Long requestId){
        return new ResponseEntity<>(prayerRequestService.deletePrayerRequest(requestId), HttpStatus.OK);
    }
}
