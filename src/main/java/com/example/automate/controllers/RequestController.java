package com.example.automate.controllers;

import com.example.automate.models.Drivers;
import com.example.automate.models.Requests;
import com.example.automate.models.Rides;
import com.example.automate.repositories.RequestRepository;
import com.example.automate.response.DriversResponse;
import jdk.nashorn.internal.ir.RuntimeNode;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/requests")
public class RequestController {

    @Autowired
    private RequestRepository requestRepository;

    @GetMapping
    public List<Requests> list() {
       return requestRepository.findAll();
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public Requests create(@RequestBody final Requests famous5){

        return requestRepository.saveAndFlush(famous5);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        //wont delete children records
        requestRepository.deleteById(id);
    }
}
