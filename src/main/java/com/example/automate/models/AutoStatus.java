package com.example.automate.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "autostatus")
@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
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

}