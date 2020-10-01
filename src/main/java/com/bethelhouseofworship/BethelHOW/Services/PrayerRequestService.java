package com.bethelhouseofworship.BethelHOW.Services;

import com.bethelhouseofworship.BethelHOW.Models.PrayerRequest;
import com.bethelhouseofworship.BethelHOW.Models.RequestStatus;
import com.bethelhouseofworship.BethelHOW.Models.Testimonial;
import com.bethelhouseofworship.BethelHOW.Repositories.PrayerRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrayerRequestService {

    @Autowired
    private PrayerRequestRepository prayerRequestRepository;

    public PrayerRequest addRequest(PrayerRequest prayerRequest){
        return prayerRequestRepository.save(prayerRequest);
    }

    public Iterable<PrayerRequest> getAllApprovedPrayerRequests(){
        return prayerRequestRepository.findAllByRequestStatusApproved(RequestStatus.APPROVED);
    }

    public Iterable<PrayerRequest> getAllDeniedPrayerRequest(){
        return prayerRequestRepository.findAllByRequestStatusDenied(RequestStatus.DENIED);
    }

    public Iterable<PrayerRequest> getAllPendingPrayerRequest(){
        return prayerRequestRepository.findAllByRequestStatusPending(RequestStatus.PENDING);
    }

    public boolean deletePrayerRequest(Long id){
        if(prayerRequestRepository.existsById(id)) {
            prayerRequestRepository.deleteById(id);
            return true;
        }
        else return false;
    }

}
