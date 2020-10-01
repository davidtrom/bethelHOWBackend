package com.bethelhouseofworship.BethelHOW.Repositories;

import com.bethelhouseofworship.BethelHOW.Models.RequestStatus;
import com.bethelhouseofworship.BethelHOW.Models.Testimonial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestimonialRepository extends CrudRepository<Testimonial, Long> {
    public Iterable<Testimonial> findAllByRequestStatusApproved(RequestStatus requestStatus);
    public Iterable<Testimonial> findAllByRequestStatusDenied(RequestStatus requestStatus);
    public Iterable<Testimonial> findAllByRequestStatusPending(RequestStatus requestStatus);
}
