package com.example.automate.models;

import com.example.automate.util.Points;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@EnableAutoConfiguration
@Entity
@Table(name = "passenger_history")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PassengerHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="passenger_id")
    private Long passengerId;
    private String date;
  //  private Float rating;
    private Points source;
    private Points destination;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public void setDate(String date) {
        this.date = date;
    }

//    public Float getRating() {
//        return rating;
//    }
//
//    public void setRating(Float rating) {
//        this.rating = rating;
//    }

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
}