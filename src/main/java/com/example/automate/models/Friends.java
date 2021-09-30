package com.example.automate.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="friends")
@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Friends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long friend_id;

    @Column(name="user_id")
    private Long userId;

    @Column(name="mobile_no")
    private String mobile_no;

    @Column(name="name")
    private String name;

}