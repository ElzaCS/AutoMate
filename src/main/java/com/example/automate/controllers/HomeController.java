package com.example.automate.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    @Value("1.0.0")
    private String appVersion;
    @Value("welcome!")
    private String greeting;
    @Value("/v2/api-docs")
    private String swaggerJsonLoc;
    @Value("swagger-ui/")
    private String swaggerUiLoc;

    @Value("/drivers")
    private String driversLoc;
    @Value("/autoStatus")
    private String autoStatusLoc;
    @Value("/driverHistory")
    private String driverHistoryLcc;
    @Value("/friends")
    private String friendsLoc;
    @Value("/passengers")
    private String passengersLoc;
    @Value("/passengerHistory")
    private String passengerHistoryLoc;
    @Value("/requests")
    private String requestsLoc;
    @Value("/rides")
    private String ridesLoc;

    @GetMapping
    @RequestMapping("/")
    public Map getStatus() {
        Map map = new HashMap<String, String>();
        //map.put("app-version",appVersion);
        map.put("Greeting", greeting);
        map.put("Swagger JSON", swaggerJsonLoc);
        map.put("Swagger UI", swaggerUiLoc);

        map.put("Drivers", driversLoc);
        map.put("Auto-Status", autoStatusLoc);
        map.put("Driver-History", driverHistoryLcc);
        map.put("Friends", friendsLoc);
        map.put("Passengers", passengersLoc);
        map.put("Passenger-History", passengerHistoryLoc);
        map.put("Requests", requestsLoc);
        map.put("Rides", ridesLoc);
        return map;
    }
}
