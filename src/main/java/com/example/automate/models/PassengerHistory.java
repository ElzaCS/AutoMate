package com.example.automate.models;

import com.example.automate.util.Points;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@EnableAutoConfiguration
@Entity
@Table(name = "passenger_history")
@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PassengerHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="passenger_id")
    private Long passengerId;
    @Column(name = "date")
    private String date;
  //  private Float rating;
    private Points source;
    private Points destination;

}