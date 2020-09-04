package com.bethelhouseofworship.BethelHOW.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PrayerRequest {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
