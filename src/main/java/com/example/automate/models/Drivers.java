package com.example.automate.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "drivers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Drivers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driver_id;
    private String drivername;
    private String password;
    private String auto_no;

    public Long getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(Long driver_id) {
        this.driver_id = driver_id;
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
}