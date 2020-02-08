package com.example.automate.models;

import com.example.automate.util.Points;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.jfr.DataAmount;
import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "drivers_history")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DriverHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ride_id;

    @Column(name="driver_id")
    private Long driverId;

    @Column(name="passenger_id")
    private Long passengerId;

    private Long driver_rating;
    private Long no_of_passengers;
    private Points source;
    private Points destination;
    private String start_time;

    public Long getRide_id() {
        return ride_id;
    }

    public void setRide_id(Long ride_id) {
        this.ride_id = ride_id;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getDriver_rating() {
        return driver_rating;
    }

    public void setDriver_rating(Long driver_rating) {
        this.driver_rating = driver_rating;
    }

    public Long getNo_of_passengers() {
        return no_of_passengers;
    }

    public void setNo_of_passengers(Long no_of_passengers) {
        this.no_of_passengers = no_of_passengers;
    }

    public Points getSource() {
        return source;
    }

    public void setSource(Points source) {
        this.source = source;
    }

    public Points getDestination() {
        return destination;
    }

    public void setDestination(Points destination) {
        this.destination = destination;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }
}