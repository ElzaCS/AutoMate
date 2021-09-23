package com.example.automate.response;

import com.example.automate.models.DriverHistory;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Singular;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

@Builder
public class DriversResponse {
    @Id
    @Column(name="driver_id")
    private Long driverId;

    private String drivername;
    private Long rating;
    private String auto_no;
    private String mobile_no;
    private List<DriverHistory> history;

    public DriversResponse(Long driverId, String drivername, Long rating, String auto_no, String mobile_no, List<DriverHistory> history) {
        this.driverId = driverId;
        this.drivername = drivername;
        this.rating = rating;
        this.auto_no = auto_no;
        this.mobile_no = mobile_no;
        this.history = history;
    }

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

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getAuto_no() {
        return auto_no;
    }

    public void setAuto_no(String auto_no) {
        this.auto_no = auto_no;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public List<DriverHistory> getHistory() {
        return history;
    }

    public void setHistory(List<DriverHistory> history) {
        this.history = history;
    }
}
