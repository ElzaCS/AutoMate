package com.example.automate.controllers;

import com.example.automate.models.DriverHistory;
import com.example.automate.models.Drivers;
import com.example.automate.models.Rides;
import com.example.automate.repositories.DriversRepository;
import com.example.automate.repositories.RidesRepository;
import com.example.automate.response.DriversResponse;
import com.example.automate.response.RidesResponse;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rides")
public class RidesController {
    @Autowired
    private RidesRepository ridesRepository;

    @Autowired
    DriversRepository driversRepository;

    @GetMapping("")
    public List<RidesResponse> list() {
        List<Rides> rides= ridesRepository.findAll();
        List<RidesResponse> rideDetails=new ArrayList<>();
        for (var ride : rides){
            rideDetails.add(RidesResponse.builder()
                    .id(ride.getId())
                    .driver_id(ride.getDriver_id())
                    .driver(driversRepository.findByDriverId(ride.getDriver_id()))
                    .next_stop(ride.getNext_stop())
                    .build());
        }
        return rideDetails;
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Rides get(@PathVariable Long id) {

        return ridesRepository.getOne(id);
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public Rides create(@RequestBody final Rides famous5){
        return ridesRepository.saveAndFlush(famous5);
    }
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        //wont delete children records
        ridesRepository.deleteById(id);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Rides update(@PathVariable Long id, @RequestBody Rides famous5){
        Rides existingFamous5=ridesRepository.getOne(id);
        BeanUtils.copyProperties(famous5, existingFamous5, "id");
        return ridesRepository.saveAndFlush(existingFamous5);
    }
}