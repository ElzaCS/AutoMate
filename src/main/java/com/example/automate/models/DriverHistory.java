package com.example.automate.models;

import com.example.automate.util.Points;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "drivers_history")
@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
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

}