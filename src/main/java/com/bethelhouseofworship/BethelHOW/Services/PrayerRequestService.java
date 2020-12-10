package com.bethelhouseofworship.BethelHOW.Services;

import com.bethelhouseofworship.BethelHOW.Models.PrayerRequest;
import com.bethelhouseofworship.BethelHOW.Models.RequestStatus;
import com.bethelhouseofworship.BethelHOW.Repositories.PrayerRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PrayerRequestService {


    @Autowired
    private PrayerRequestRepository prayerRequestRepository;

    public PrayerRequest addRequest(PrayerRequest prayerRequest){
        return prayerRequestRepository.save(prayerRequest);
    }

    public Iterable<PrayerRequest> getAllApprovedPrayerRequests(){
        return prayerRequestRepository.findAllByRequestStatus(RequestStatus.APPROVED);
    }

    public Iterable<PrayerRequest> getAllDeniedPrayerRequests(){
        return prayerRequestRepository.findAllByRequestStatus(RequestStatus.DENIED);
    }

    public Iterable<PrayerRequest> getAllPendingPrayerRequests(){
        return prayerRequestRepository.findAllByRequestStatus(RequestStatus.PENDING);
    }

    public boolean deletePrayerRequest(Long id){
        if(prayerRequestRepository.existsById(id)) {
            prayerRequestRepository.deleteById(id);
            return true;
        }
        else return false;
    }

    public PrayerRequest approveRequest(Long id){
        PrayerRequest requestToApprove = prayerRequestRepository.findById(id).get();
        requestToApprove.setRequestStatus(RequestStatus.APPROVED);
        return prayerRequestRepository.save(requestToApprove);
    }

    public PrayerRequest denyRequest(Long id){
        PrayerRequest requestToDeny = prayerRequestRepository.findById(id).get();
        requestToDeny.setRequestStatus(RequestStatus.DENIED);
        return prayerRequestRepository.save(requestToDeny);
    }

    public PrayerRequest pendingRequest(Long id){
        PrayerRequest requestToPending = prayerRequestRepository.findById(id).get();
        requestToPending.setRequestStatus(RequestStatus.PENDING);
        return prayerRequestRepository.save(requestToPending);
    }

    public boolean approveAllRequests(){
        System.out.println("Inside approve all requests");
        Boolean flag = null;
        List<PrayerRequest> allPendingRequestsList = new ArrayList<PrayerRequest>();
        Iterable<PrayerRequest> allPendingRequests = prayerRequestRepository.findAllByRequestStatus(RequestStatus.PENDING);
        allPendingRequests.forEach(allPendingRequestsList::add);
        try {
            for (PrayerRequest request : allPendingRequestsList) {
                request.setRequestStatus(RequestStatus.APPROVED);
                prayerRequestRepository.save(request);
            }
            flag = true;
        } catch (Exception e){
            flag = false;
        }
        System.out.println(flag);
        return flag;
    }

}
