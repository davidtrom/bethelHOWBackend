package com.bethelhouseofworship.BethelHOW.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class PrayerRequest {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String locationCity;
    private String locationState;
    private String locationCountry;
    private String prayerRequest;
    private LocalDate creationDate  = LocalDate.now();
    private RequestStatus requestStatus = RequestStatus.PENDING;

    public PrayerRequest(){}

    public PrayerRequest(Long id, String firstName, String lastName, String locationCity, String locationState, String locationCountry, String prayerRequest, LocalDate creationDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.locationCity = locationCity;
        this.locationState = locationState;
        this.locationCountry = locationCountry;
        this.prayerRequest = prayerRequest;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationState() {
        return locationState;
    }

    public void setLocationState(String locationState) {
        this.locationState = locationState;
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    public String getPrayerRequest() {
        return prayerRequest;
    }

    public void setPrayerRequest(String testimonial) {
        this.prayerRequest = testimonial;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }
}
