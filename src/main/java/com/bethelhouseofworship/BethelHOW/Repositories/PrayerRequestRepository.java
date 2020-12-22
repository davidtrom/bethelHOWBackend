package com.bethelhouseofworship.BethelHOW.Repositories;

import com.bethelhouseofworship.BethelHOW.Models.PrayerRequest;
import com.bethelhouseofworship.BethelHOW.Models.RequestStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrayerRequestRepository extends CrudRepository<PrayerRequest, Long> {
    Iterable<PrayerRequest> findAllByRequestStatus(RequestStatus requestStatus);
}
