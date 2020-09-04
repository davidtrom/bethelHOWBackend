package com.bethelhouseofworship.BethelHOW.Repositories;

import com.bethelhouseofworship.BethelHOW.Models.PrayerRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrayerRequestRepository extends CrudRepository<PrayerRequest, Long> {
}
