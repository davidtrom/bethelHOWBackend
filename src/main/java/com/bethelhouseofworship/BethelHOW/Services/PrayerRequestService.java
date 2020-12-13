package com.bethelhouseofworship.BethelHOW.Services;

import com.bethelhouseofworship.BethelHOW.Models.PrayerRequest;
import com.bethelhouseofworship.BethelHOW.Models.RequestStatus;
import com.bethelhouseofworship.BethelHOW.Repositories.PrayerRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

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

    public Boolean approveAllRequests(){
        Boolean flag;
        List<PrayerRequest> allPendingRequestsList = new ArrayList<>();
        Iterable<PrayerRequest> allPendingRequests = prayerRequestRepository.findAllByRequestStatus(RequestStatus.PENDING);
        allPendingRequests.forEach(allPendingRequestsList::add);
        try {
            System.out.println("Inside Try");
            for (PrayerRequest request : allPendingRequestsList) {
                request.setRequestStatus(RequestStatus.APPROVED);
                prayerRequestRepository.save(request);
            }
            flag = true;
        } catch (Exception e){
            flag = false;
        }
        return flag;
    }

    public Boolean deleteDeniedRequests(){
        Boolean flag;
        Iterable<PrayerRequest> allDeniedRequests = prayerRequestRepository.findAllByRequestStatus(RequestStatus.DENIED);
        try{
            prayerRequestRepository.deleteAll(allDeniedRequests);
            flag = true;
        }catch (Exception e){
            flag = false;
        }
        return flag;
    }

    public Boolean removeOutdatedRequests(){
        //Prayer Requests deleted after 60 days
        Boolean flag;
        List<PrayerRequest> allRequestsList = new ArrayList<>();
        Iterable<PrayerRequest> getAllRequests = prayerRequestRepository.findAll();
        getAllRequests.forEach(allRequestsList::add);
        try{
            for (PrayerRequest request: allRequestsList){
                LocalDate creationDate = request.getCreationDate();
                long diff = ChronoUnit.DAYS.between(creationDate, LocalDate.now());
                if(diff > 60){
                    prayerRequestRepository.delete(request);
                }
            }
            flag = true;

        } catch(Exception e){
            flag = false;
        }
        return flag;
    }

}
