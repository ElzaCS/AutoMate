package com.example.automate.controllers;

import com.example.automate.models.Passengers;
import com.example.automate.repositories.PassengerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/passengers")
public class PassengerController {
    @Autowired
    private PassengerRepository passengerRepository;

    @GetMapping
    public List<Passengers> list() {
        return passengerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Passengers get(@PathVariable Long id) {
        return passengerRepository.getOne(id);
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public Passengers create(@RequestBody final Passengers famous5){
        return passengerRepository.saveAndFlush(famous5);
    }
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        //wont delete children records
        passengerRepository.deleteById(id);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Passengers update(@PathVariable Long id, @RequestBody Passengers famous5){
        Passengers existingFamous5=passengerRepository.getOne(id);
        BeanUtils.copyProperties(famous5, existingFamous5, "id");
        return passengerRepository.saveAndFlush(existingFamous5);
    }
}