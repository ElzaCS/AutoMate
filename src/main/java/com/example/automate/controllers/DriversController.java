package com.example.automate.controllers;

import com.example.automate.models.Drivers;
import com.example.automate.repositories.DriverHistoryRepository;
import com.example.automate.repositories.DriversRepository;
import com.example.automate.response.DriverLoginRequest;
import com.example.automate.response.DriversResponse;
import com.example.automate.response.UserLoginRequest;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriversController {
    @Autowired
    private DriversRepository driversRepository;

    @Autowired
    private DriverHistoryRepository driverHistoryRepository;

    @GetMapping
    @ApiOperation(value = "List all drivers")
    public List<DriversResponse> list() {
        // return driversRepository.findAll();
        List<Drivers> drivers = driversRepository.findAll();
        List<DriversResponse> driversDetails = new ArrayList<>();
        for (Drivers driver : drivers) {
            driversDetails.add(new DriversResponse(driver.getDriverId(), driver.getDrivername(), driver.getRating(), driver.getAuto_no(),
                    driver.getMobile_no(), driverHistoryRepository.findAllByDriverId(driver.getDriverId())));
//            driversDetails.add(DriversResponse.builder()
//                    .driverId(driver.getDriverId())
//                    .auto_no(driver.getAuto_no())
//                    .drivername(driver.getDrivername())
//                    .mobile_no(driver.getMobile_no())
//                    .rating(driver.getRating())
//                    .history(driverHistoryRepository.findAllByDriverId(driver.getDriverId()))
//                    .build());
        }
        return driversDetails;
    }

    @GetMapping
    @RequestMapping(value = "getDrivers/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get details of a driver")
    public Drivers get(@PathVariable Long id) {
        return driversRepository.getOne(id);
    }

    @PostMapping("/signin")
    @ApiOperation(value = "Sign-up a driver")
    public Drivers signin(@RequestBody final Drivers famous5) {

        return driversRepository.saveAndFlush(famous5);
    }

    @PostMapping("/login")
    @ApiOperation(value = "Login a driver")
    public Boolean login(@RequestBody final DriverLoginRequest creds) {
        Drivers existingDriver = driversRepository.findByDrivername(creds.getUsername());
        if (existingDriver.getPassword().equals(creds.getPassword()))
            return true;
        else
            return false;
    }

    @ApiOperation(value = "Remove a driver")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //wont delete children records
        driversRepository.deleteById(id);
    }

    @ApiOperation(value = "Update a driver's details")
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Drivers update(@PathVariable Long id, @RequestBody Drivers famous5) {
        Drivers existingFamous5 = driversRepository.getOne(id);
        BeanUtils.copyProperties(famous5, existingFamous5, "id");
        return driversRepository.saveAndFlush(existingFamous5);
    }
}