package com.bethelhouseofworship.BethelHOW.Repositories;

import com.bethelhouseofworship.BethelHOW.Models.Testimonial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestimonialRepository extends CrudRepository<Testimonial, Long> {

}
