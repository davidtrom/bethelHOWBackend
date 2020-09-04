package com.bethelhouseofworship.BethelHOW.Controllers;


import com.bethelhouseofworship.BethelHOW.Services.PrayerRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prayer-requests")
public class PrayerRequestController {

    @Autowired
    private PrayerRequestService prayerRequestService;
}
