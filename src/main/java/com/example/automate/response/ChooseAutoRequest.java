package com.example.automate.response;

import lombok.Builder;

@Builder
public class ChooseAutoRequest {
    private Long passengerId;
    private Float sourceLatitude;
    private Float sourceLongitude;
    private String destination;

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
