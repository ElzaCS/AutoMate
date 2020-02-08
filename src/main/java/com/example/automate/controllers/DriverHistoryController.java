package com.example.automate.controllers;

import com.example.automate.models.DriverHistory;
import com.example.automate.repositories.DriverHistoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/driverHistory")
public class DriverHistoryController {
    @Autowired
    private DriverHistoryRepository driverHistoryRepository;

    @GetMapping
    public List<DriverHistory> list() {
        return driverHistoryRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public DriverHistory get(@PathVariable Long id) {
        return driverHistoryRepository.getOne(id);
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public DriverHistory create(@RequestBody final DriverHistory famous5){
        return driverHistoryRepository.saveAndFlush(famous5);
    }
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        //wont delete children records
        driverHistoryRepository.deleteById(id);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public DriverHistory update(@PathVariable Long id,@RequestBody DriverHistory famous5){
        DriverHistory existingFamous5=driverHistoryRepository.getOne(id);
        BeanUtils.copyProperties(famous5, existingFamous5, "id");
        return driverHistoryRepository.saveAndFlush(existingFamous5);
    }

}