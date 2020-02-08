package com.example.automate.response;

import com.example.automate.models.Drivers;
import lombok.Builder;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
public class RidesResponse {
    @Id
    private Long id;
    private Long driver_id;
    private Drivers driver;
    private String next_stop;

}
