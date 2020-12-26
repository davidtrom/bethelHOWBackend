package com.bethelhouseofworship.BethelHOW.Services;


import com.bethelhouseofworship.BethelHOW.Models.RequestStatus;
import com.bethelhouseofworship.BethelHOW.Models.Testimonial;
import com.bethelhouseofworship.BethelHOW.Repositories.TestimonialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestimonialService {

    @Autowired
    private TestimonialRepository testimonialRepository;

    public Boolean addTestimonial(Testimonial testimonial){
        Boolean didEmailSend;
        try{
            didEmailSend = SendMail.sendNotificationMessage(testimonial);
            testimonialRepository.save(testimonial);
        } catch (Exception e){
            didEmailSend = false;
        }
        return didEmailSend;
    }

    public Iterable<Testimonial> getAllApprovedTestimonials(){
        return testimonialRepository.findAllByRequestStatus(RequestStatus.APPROVED);
    }

    public Iterable<Testimonial> getAllDeniedTestimonials(){
        return testimonialRepository.findAllByRequestStatus(RequestStatus.DENIED);
    }

    public Iterable<Testimonial> getAllPendingTestimonials(){
        return testimonialRepository.findAllByRequestStatus(RequestStatus.PENDING);
    }

    public boolean deleteTestimonial(Long id){
        if(testimonialRepository.existsById(id)) {
            testimonialRepository.deleteById(id);
            return true;
        }
        else return false;
    }
    
    public Testimonial approveTestimonial(Long id){
        Testimonial requestToApprove = testimonialRepository.findById(id).get();
        requestToApprove.setRequestStatus(RequestStatus.APPROVED);
        return testimonialRepository.save(requestToApprove);
    }

    public Testimonial denyTestimonial(Long id){
        Testimonial requestToDeny = testimonialRepository.findById(id).get();
        requestToDeny.setRequestStatus(RequestStatus.DENIED);
        return testimonialRepository.save(requestToDeny);
    }

    public Testimonial pendingRequest(Long id){
        Testimonial requestToPending = testimonialRepository.findById(id).get();
        requestToPending.setRequestStatus(RequestStatus.PENDING);
        return testimonialRepository.save(requestToPending);
    }

    public Boolean approveAllTestimonials(){
        Boolean flag;
        List<Testimonial> allPendingTestimonialsList = new ArrayList<>();
        Iterable<Testimonial> allPendingTestimonials = testimonialRepository.findAllByRequestStatus(RequestStatus.PENDING);
        allPendingTestimonials.forEach(allPendingTestimonialsList::add);
        try {
            for (Testimonial request : allPendingTestimonialsList) {
                request.setRequestStatus(RequestStatus.APPROVED);
                testimonialRepository.save(request);
            }
            flag = true;
        } catch (Exception e){
            flag = false;
        }
        return flag;
    }

    public Boolean deleteDeniedTestimonials(){
        Boolean flag;
        Iterable<Testimonial> allDeniedTestimonials = testimonialRepository.findAllByRequestStatus(RequestStatus.DENIED);
        try{
            testimonialRepository.deleteAll(allDeniedTestimonials);
            flag = true;
        }catch (Exception e){
            flag = false;
        }
        return flag;
    }

    public Boolean removeOutdatedTestimonials(){
        //Testimonials deleted after 365 days
        Boolean flag;
        List<Testimonial> allTestimonialsList = new ArrayList<>();
        Iterable<Testimonial> getAllTestimonials = testimonialRepository.findAll();
        getAllTestimonials.forEach(allTestimonialsList::add);
        try{
            for (Testimonial request: allTestimonialsList){
                long diff = ChronoUnit.DAYS.between(request.getCreationDate(), LocalDate.now());
                if(diff > 365){
                    testimonialRepository.delete(request);
                }
            }
            flag = true;

        } catch(Exception e){
            flag = false;
        }
        return flag;
    }
}
