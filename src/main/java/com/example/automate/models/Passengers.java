package com.example.automate.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "passengers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Passengers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passenger_id;
    private String name;
    private String mobile;
    private String is_riding;
    private String rating;

    public Long getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(Long passenger_id) {
        this.passenger_id = passenger_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIs_riding() {
        return is_riding;
    }

    public void setIs_riding(String is_riding) {
        this.is_riding = is_riding;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
