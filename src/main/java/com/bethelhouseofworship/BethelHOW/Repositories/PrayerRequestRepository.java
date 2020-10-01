package com.bethelhouseofworship.BethelHOW.Repositories;

import com.bethelhouseofworship.BethelHOW.Models.PrayerRequest;
import com.bethelhouseofworship.BethelHOW.Models.RequestStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrayerRequestRepository extends CrudRepository<PrayerRequest, Long> {
    public Iterable<PrayerRequest> findAllByRequestStatusApproved(RequestStatus requestStatus);
    public Iterable<PrayerRequest> findAllByRequestStatusDenied(RequestStatus requestStatus);
    public Iterable<PrayerRequest> findAllByRequestStatusPending(RequestStatus requestStatus);
}
