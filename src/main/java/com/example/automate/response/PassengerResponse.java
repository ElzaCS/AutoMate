package com.example.automate.response;

import com.example.automate.models.DriverHistory;
import com.example.automate.models.Friends;
import com.example.automate.models.PassengerHistory;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Singular;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

@Builder
public class PassengerResponse {
    @Id
    @Column(name="passenger_id")
    private Long passengerId;
    private String name;
    private String mobile;
    private String gender;
//    private String is_riding;
//    private String rating;
    private List<Friends> friends;
    private List<DriverHistory> histories;

    public PassengerResponse(Long passengerId, String name, String mobile, String gender, List<Friends> friends, List<DriverHistory> histories) {
        this.passengerId = passengerId;
        this.name = name;
        this.mobile = mobile;
        this.gender = gender;
        this.friends = friends;
        this.histories = histories;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

//    public String getIs_riding() {
//        return is_riding;
//    }
//
//    public void setIs_riding(String is_riding) {
//        this.is_riding = is_riding;
//    }
//
//    public String getRating() {
//        return rating;
//    }
//
//    public void setRating(String rating) {
//        this.rating = rating;
//    }

    public List<Friends> getFriends() {
        return friends;
    }

    public void setFriends(List<Friends> friends) {
        this.friends = friends;
    }

    public List<DriverHistory> getHistories() {
        return histories;
    }

    public void setHistories(List<DriverHistory> histories) {
        this.histories = histories;
    }
}