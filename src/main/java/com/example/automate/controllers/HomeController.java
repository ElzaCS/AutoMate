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
    @Value("/api/v1/famous5")
    private String famous5loc;
    @Value("/api/v1/stclare")
    private String stclareloc;
    @Value("/api/v1/users")
    private String usersloc;


    @GetMapping
    @RequestMapping("/")
    public Map getStatus(){
        Map map=new HashMap<String, String>();
        //map.put("app-version",appVersion);
        map.put("Greeting",greeting);
        map.put("Famous5",famous5loc);
        map.put("St.Clare",stclareloc);
        map.put("Users",usersloc);
        return map;
    }
}
