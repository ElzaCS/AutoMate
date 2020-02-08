package com.example.automate.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "drivers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Drivers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="driver_id")
    private Long driverId;

    private String drivername;
    private Long rating;
    private String password;
    private String auto_no;
    private String mobile_no;


    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuto_no() {
        return auto_no;
    }

    public void setAuto_no(String auto_no) {
        this.auto_no = auto_no;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }
}