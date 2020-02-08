package com.example.automate.controllers;

import com.example.automate.models.DriverHistory;
import com.example.automate.models.Drivers;
import com.example.automate.models.Friends;
import com.example.automate.models.Passengers;
import com.example.automate.repositories.FriendsRepository;
import com.example.automate.repositories.PassengerHistoryRepository;
import com.example.automate.repositories.PassengerRepository;
import com.example.automate.response.DriversResponse;
import com.example.automate.response.PassengerResponse;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/passengers")
public class PassengerController {
    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private FriendsRepository friendsRepository;

    @Autowired
    private PassengerHistoryRepository passengerHistoryRepository;

    @GetMapping
    public List<PassengerResponse> list() {

        List<Passengers> passengers= passengerRepository.findAll();
        List<PassengerResponse> passengerDetails=new ArrayList<>();
        for (var passenger : passengers){
            passengerDetails.add(PassengerResponse.builder()
                    .passengerId(passenger.getPassengerId())
                    .name(passenger.getName())
                    .gender(passenger.getGender())
                    .is_riding(passenger.getIs_riding())
                    .mobile(passenger.getMobile())
                    .rating(passenger.getRating())
                    .friends(friendsRepository.findAllByUserId(passenger.getPassengerId()))
                    .histories(passengerHistoryRepository.findByPassengerId(passenger.getPassengerId()))
                    .build());
        }
        return passengerDetails;
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