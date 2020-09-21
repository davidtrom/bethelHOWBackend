package com.bethelhouseofworship.BethelHOW.Services;

import com.bethelhouseofworship.BethelHOW.Models.PrayerRequest;
import com.bethelhouseofworship.BethelHOW.Repositories.PrayerRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrayerRequestService {

    @Autowired
    private PrayerRequestRepository prayerRequestRepository;

    public PrayerRequest addRequest(PrayerRequest prayerRequest){

        System.out.println(prayerRequest.getLocationCity());
        return prayerRequestRepository.save(prayerRequest);
    }

    public Iterable<PrayerRequest> getAllPrayerRequests(){
        return prayerRequestRepository.findAll();
    }

    public boolean deletePrayerRequest(Long id){
        if(prayerRequestRepository.existsById(id)) {
            prayerRequestRepository.deleteById(id);
            return true;
        }
        else return false;
    }

}
