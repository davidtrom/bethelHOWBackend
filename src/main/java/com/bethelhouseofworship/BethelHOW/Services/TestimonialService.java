package com.bethelhouseofworship.BethelHOW.Services;

import com.bethelhouseofworship.BethelHOW.Models.RequestStatus;
import com.bethelhouseofworship.BethelHOW.Models.Testimonial;
import com.bethelhouseofworship.BethelHOW.Repositories.TestimonialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestimonialService {

    @Autowired
    private TestimonialRepository testimonialRepository;

    public Testimonial addTestimonial(Testimonial testimonial){
        return testimonialRepository.save(testimonial);
    }

    public Iterable<Testimonial> getAllApprovedTestimonials(){
        return testimonialRepository.findAllByRequestStatus(RequestStatus.APPROVED);
    }

//    public Iterable<Testimonial> getAllDeniedTestimonials(){
//        return testimonialRepository.findAllByRequestStatusDenied(RequestStatus.DENIED);
//    }
//
//    public Iterable<Testimonial> getAllPendingTestimonials(){
//        return testimonialRepository.findAllByRequestStatusPending(RequestStatus.PENDING);
//    }

    public boolean deleteTestimonial(Long id){
        if(testimonialRepository.existsById(id)) {
            testimonialRepository.deleteById(id);
            return true;
        }
        else return false;
    }
}
