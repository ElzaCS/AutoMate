package com.example.automate.response;

import lombok.Builder;

@Builder
public class UserLoginRequest {
    private Long roll_no;
    private String password;

    public Long getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(Long roll_no) {
        this.roll_no = roll_no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
