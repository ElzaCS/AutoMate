package com.example.automate.response;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Id;

@Builder
public class DriverHistoryResponse {
    @Id
    private Long ride_id;

    @Column(name="driver_id")
    private Long driverId;
    private Long driver_rating;
    private Long no_of_passengers;
    private String source;
    private String destination;
    private String date;
}
