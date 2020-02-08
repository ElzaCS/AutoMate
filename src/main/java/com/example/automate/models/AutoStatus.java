package com.example.automate.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "autostatus")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AutoStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auto_id")
    private Long autoId;

    @Column(name="auto_latitude")
    private Float autoLatitude;

    @Column(name="auto_longitude")
    private Float autoLongitude;

    @Column(name="last_updated_at")
    private String lastUpdatedAt;

    public Long getAutoId() {
        return autoId;
    }

    public void setAutoId(Long autoId) {
        this.autoId = autoId;
    }

    public Float getAutoLatitude() {
        return autoLatitude;
    }

    public void setAutoLatitude(Float autoLatitude) {
        this.autoLatitude = autoLatitude;
    }

    public Float getAutoLongitude() {
        return autoLongitude;
    }

    public void setAutoLongitude(Float autoLongitude) {
        this.autoLongitude = autoLongitude;
    }

    public String getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(String lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }
}