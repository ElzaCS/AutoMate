package com.example.automate.controllers;

import com.example.automate.models.DriverHistory;
import com.example.automate.repositories.RidesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rides")
public class RidesController {
    @Autowired
    private RidesRepository ridesRepository;

    @GetMapping("")
    public List<DriverHistory> list() {
        return ridesRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public DriverHistory get(@PathVariable Long id) {
        return ridesRepository.getOne(id);
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public DriverHistory create(@RequestBody final DriverHistory famous5){
        return ridesRepository.saveAndFlush(famous5);
    }
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        //wont delete children records
        ridesRepository.deleteById(id);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public DriverHistory update(@PathVariable Long id, @RequestBody DriverHistory famous5){
        DriverHistory existingFamous5=ridesRepository.getOne(id);
        BeanUtils.copyProperties(famous5, existingFamous5, "id");
        return ridesRepository.saveAndFlush(existingFamous5);
    }
}