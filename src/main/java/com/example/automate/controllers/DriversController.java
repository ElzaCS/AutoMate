package com.example.automate.controllers;

import com.example.automate.models.Drivers;
import com.example.automate.repositories.DriversRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/drivers")
public class DriversController {
    @Autowired
    private DriversRepository driversRepository;

    @GetMapping
    public List<Drivers> list() {
        return driversRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Drivers get(@PathVariable Long id) {
        return driversRepository.getOne(id);
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public Drivers create(@RequestBody final Drivers famous5){
        return driversRepository.saveAndFlush(famous5);
    }
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        //wont delete children records
        driversRepository.deleteById(id);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Drivers update(@PathVariable Long id,@RequestBody Drivers famous5){
        Drivers existingFamous5=driversRepository.getOne(id);
        BeanUtils.copyProperties(famous5, existingFamous5, "id");
        return driversRepository.saveAndFlush(existingFamous5);
    }
}