package com.example.automate.controllers;

import com.example.automate.models.Requests;
import com.example.automate.repositories.RequestRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
public class RequestController {

    @Autowired
    private RequestRepository requestRepository;

    @GetMapping
    @ApiOperation(value = "List all ride-requests")
    public List<Requests> list() {
        return requestRepository.findAll();
    }

    @PostMapping
    @ApiOperation(value = "Add a new ride-request")
    public Requests create(@RequestBody final Requests famous5) {

        return requestRepository.saveAndFlush(famous5);
    }

    @ApiOperation(value = "Delete a ride-request")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //wont delete children records
        requestRepository.deleteById(id);
    }
}
