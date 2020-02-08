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

    @Column(name="auto_position")
    private String autoPosition;

    @Column(name="last_updated_at")
    private String lastUpdatedAt;

    public Long getAutoId() {
        return autoId;
    }

    public void setAutoId(Long autoId) {
        this.autoId = autoId;
    }

    public String getAutoPosition() {
        return autoPosition;
    }

    public void setAutoPosition(String autoPosition) {
        this.autoPosition = autoPosition;
    }

    public String getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(String lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }
}