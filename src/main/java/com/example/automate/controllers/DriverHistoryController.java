package com.example.automate.controllers;

import com.example.automate.models.DriverHistory;
import com.example.automate.models.Drivers;
import com.example.automate.repositories.DriverHistoryRepository;
import com.example.automate.repositories.DriversRepository;
import com.example.automate.response.DriversResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driverHistory")
public class DriverHistoryController {
    @Autowired
    private DriverHistoryRepository driverHistoryRepository;

    @Autowired
    private DriversRepository driversRepository;

    @GetMapping
    @ApiOperation(value = "List all drivers history")
    public List<DriverHistory> list() {
        return driverHistoryRepository.findAll();
    }

    @GetMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get history of a driver")
    public List<DriverHistory> get(@PathVariable Long id) {
        return driverHistoryRepository.findAllByDriverId(id);
    }

    @PostMapping
    @ApiOperation(value = "Add a record on a driver's history when a passenger checks-in")
    public DriversResponse checkin(@RequestBody final DriverHistory driver) {
        Drivers givenDriver = driversRepository.findByDriverId(driver.getDriverId());
        DriversResponse drivers = new DriversResponse(driver.getDriverId(), givenDriver.getDrivername(), driver.getDriver_rating(), givenDriver.getAuto_no(),
                givenDriver.getMobile_no(), driverHistoryRepository.findAllByDriverId(driver.getDriverId()));
//        DriversResponse drivers = DriversResponse.builder()
//                .driverId(driver.getDriverId())
//                .auto_no(givenDriver.getAuto_no())
//                .drivername(givenDriver.getDrivername())
//                .mobile_no(givenDriver.getMobile_no())
//                .rating(driver.getDriver_rating())
//                .history(driverHistoryRepository.findAllByDriverId(driver.getDriverId()))
//                .build();

        driverHistoryRepository.saveAndFlush(driver);
        return drivers;
    }

    @ApiOperation(value = "Delete a particular record from history")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //wont delete children records
        driverHistoryRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update a particular record from history")
    public DriverHistory update(@PathVariable Long id, @RequestBody DriverHistory famous5) {
        DriverHistory existingFamous5 = driverHistoryRepository.getOne(id);
        BeanUtils.copyProperties(famous5, existingFamous5, "id");
        return driverHistoryRepository.saveAndFlush(existingFamous5);
    }

}