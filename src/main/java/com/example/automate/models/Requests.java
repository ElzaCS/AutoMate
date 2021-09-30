package com.example.automate.models;

import com.example.automate.util.Points;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "requests")
@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Requests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="request_id")
    private Long requestId;

    @Column(name="user_id")
    private Long userId;

    @Column(name = "source_latitude")
    private Float sourceLatitude;

    @Column(name = "source_longitude")
    private Float sourceLongitude;

    @Column(name="destination_latitude")
    private Float destinationLatitude;

    @Column(name="destination_longitude")
    private Float destinationLongitude;

    @Column(name="request_time")
    private String requestTime;
}
