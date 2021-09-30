package com.example.automate.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import lombok.*;

import java.util.List;

@Entity
@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
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

}