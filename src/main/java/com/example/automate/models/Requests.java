package com.example.automate.models;

import com.example.automate.util.Points;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "requests")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Requests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="request_id")
    private Long requestId;

    @Column(name="user_id")
    private Long userId;

    private Float sourceLatitude;
    private Float sourceLongitude;

    @Column(name="destination_latitude")
    private Float destinationLatitude;

    @Column(name="destination_longitude")
    private Float destinationLongitude;

    @Column(name="request_time")
    private String requestTime;

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Float getSourceLatitude() {
        return sourceLatitude;
    }

    public void setSourceLatitude(Float sourceLatitude) {
        this.sourceLatitude = sourceLatitude;
    }

    public Float getSourceLongitude() {
        return sourceLongitude;
    }

    public void setSourceLongitude(Float sourceLongitude) {
        this.sourceLongitude = sourceLongitude;
    }

    public Float getDestinationLatitude() {
        return destinationLatitude;
    }

    public void setDestinationLatitude(Float destinationLatitude) {
        this.destinationLatitude = destinationLatitude;
    }

    public Float getDestinationLongitude() {
        return destinationLongitude;
    }

    public void setDestinationLongitude(Float destinationLongitude) {
        this.destinationLongitude = destinationLongitude;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }
}
