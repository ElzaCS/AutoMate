package com.example.automate.controllers;

import com.example.automate.models.PassengerHistory;
import com.example.automate.repositories.PassengerHistoryRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengerHistory")
public class PassengerHistoryController {
    @Autowired
    private PassengerHistoryRepository passengerHistoryRepository;

    @GetMapping
    @ApiOperation(value = "List all passenger history")
    public List<PassengerHistory> list() {
        return passengerHistoryRepository.findAll();
    }

    @GetMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "List history of a passenger")
    public PassengerHistory get(@PathVariable Long id) {
        return passengerHistoryRepository.getOne(id);
    }

    @PostMapping
    @ApiOperation(value = "Add a record to a passenger's history")
    public PassengerHistory create(@RequestBody final PassengerHistory famous5){
        return passengerHistoryRepository.saveAndFlush(famous5);
    }
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "Remove a record from a passenger's history")
    public void delete(@PathVariable Long id){
        //wont delete children records
        passengerHistoryRepository.deleteById(id);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update a record from a passenger's history")
    public PassengerHistory update(@PathVariable Long id, @RequestBody PassengerHistory famous5){
        PassengerHistory existingFamous5=passengerHistoryRepository.getOne(id);
        BeanUtils.copyProperties(famous5, existingFamous5, "id");
        return passengerHistoryRepository.saveAndFlush(existingFamous5);
    }
}