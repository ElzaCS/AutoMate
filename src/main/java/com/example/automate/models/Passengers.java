package com.example.automate.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "passengers")
@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Passengers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="passenger_id")
    private Long passengerId;

    private String name;
    @Column(name="roll_no")
    private Long rollNo;
    private String mobile;
    private String gender;
    private String password;
//    private String is_riding;
 //   private String rating;

}
