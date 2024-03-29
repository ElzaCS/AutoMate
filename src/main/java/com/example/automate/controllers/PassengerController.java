package com.example.automate.controllers;

import com.example.automate.models.Passengers;
import com.example.automate.repositories.DriverHistoryRepository;
import com.example.automate.repositories.FriendsRepository;
import com.example.automate.repositories.PassengerHistoryRepository;
import com.example.automate.repositories.PassengerRepository;
import com.example.automate.response.UserLoginRequest;
import com.example.automate.response.PassengerResponse;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {
    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private FriendsRepository friendsRepository;

    @Autowired
    private PassengerHistoryRepository passengerHistoryRepository;

    @Autowired
    private DriverHistoryRepository driverHistoryRepository;

    @GetMapping
    @ApiOperation(value = "List all passengers")
    public List<PassengerResponse> list() {

        List<Passengers> passengers= passengerRepository.findAll();
        List<PassengerResponse> passengerDetails=new ArrayList<>();
        for (Passengers passenger : passengers){
            passengerDetails.add(new PassengerResponse(passenger.getPassengerId(), passenger.getName(), passenger.getMobile(), passenger.getGender(),
                    friendsRepository.findAllByUserId(passenger.getPassengerId()), driverHistoryRepository.findAllByPassengerId(passenger.getPassengerId())));
//            passengerDetails.add(PassengerResponse.builder()
//                    .passengerId(passenger.getPassengerId())
//                    .name(passenger.getName())
//                    .gender(passenger.getGender())
//                    //.is_riding(passenger.getIs_riding())
//                    .mobile(passenger.getMobile())
//                    //.rating(passenger.getRating())
//                    .friends(friendsRepository.findAllByUserId(passenger.getPassengerId()))
//                    .histories(driverHistoryRepository.findAllByPassengerId(passenger.getPassengerId()))
//                    .build());
        }
        return passengerDetails;
    }

    @GetMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get details of a passenger")
    public Passengers get(@PathVariable Long id) {
        return passengerRepository.getOne(id);
    }

    @PostMapping("/signin")
    @ApiOperation(value = "Sign-up a passenger")
    //@ResponseStatus(HttpStatus.CREATED)
    public Passengers signin(@RequestBody final Passengers famous5){

        return passengerRepository.saveAndFlush(famous5);
    }

    @PostMapping("/login")
    @ApiOperation(value = "Login a passenger")
    public Boolean login(@RequestBody UserLoginRequest creds){
        Passengers existingDriver = passengerRepository.findByRollNo(creds.getRoll_no());
        if (existingDriver.getPassword().equals(creds.getPassword()))
            return true;
        else
            return false;
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "Remove a passenger account")
    public void delete(@PathVariable Long id){
        //wont delete children records
        passengerRepository.deleteById(id);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update details of a passenger")
    public Passengers update(@PathVariable Long id, @RequestBody Passengers famous5){
        Passengers existingFamous5=passengerRepository.getOne(id);
        BeanUtils.copyProperties(famous5, existingFamous5, "id");
        return passengerRepository.saveAndFlush(existingFamous5);
    }
}