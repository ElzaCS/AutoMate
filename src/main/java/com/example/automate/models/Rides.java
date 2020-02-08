package com.example.automate.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "rides")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rides {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long driver_id;
    private String next_stop;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(Long driver_id) {
        this.driver_id = driver_id;
    }

    public String getNext_stop() {
        return next_stop;
    }

    public void setNext_stop(String next_stop) {
        this.next_stop = next_stop;
    }
}