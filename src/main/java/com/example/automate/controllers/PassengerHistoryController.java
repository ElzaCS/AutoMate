package com.example.automate.controllers;

import com.example.automate.models.PassengerHistory;
import com.example.automate.repositories.PassengerHistoryRepository;
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
    public List<PassengerHistory> list() {
        return passengerHistoryRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public PassengerHistory get(@PathVariable Long id) {
        return passengerHistoryRepository.getOne(id);
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public PassengerHistory create(@RequestBody final PassengerHistory famous5){
        return passengerHistoryRepository.saveAndFlush(famous5);
    }
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        //wont delete children records
        passengerHistoryRepository.deleteById(id);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public PassengerHistory update(@PathVariable Long id, @RequestBody PassengerHistory famous5){
        PassengerHistory existingFamous5=passengerHistoryRepository.getOne(id);
        BeanUtils.copyProperties(famous5, existingFamous5, "id");
        return passengerHistoryRepository.saveAndFlush(existingFamous5);
    }
}