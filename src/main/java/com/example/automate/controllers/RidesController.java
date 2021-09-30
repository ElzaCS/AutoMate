package com.example.automate.controllers;

import com.example.automate.models.AutoStatus;
import com.example.automate.models.Requests;
import com.example.automate.models.Rides;
import com.example.automate.repositories.AutoStatusRepository;
import com.example.automate.repositories.DriversRepository;
import com.example.automate.repositories.RequestRepository;
import com.example.automate.repositories.RidesRepository;
import com.example.automate.response.ChooseAutoRequest;
import com.example.automate.response.ChooseAutoResponse;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/rides")
public class RidesController {
    @Autowired
    DriversRepository driversRepository;
    @Autowired
    AutoStatusRepository autoStatusRepository;
    @Autowired
    RequestRepository requestRepository;
    @Autowired
    private RidesRepository ridesRepository;

    @GetMapping("")
    @ApiOperation(value = "List all rides")
    public List<Rides> list() {
        return ridesRepository.findAll();
    }

    @GetMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "List all rides taken by a driver")
    public List<Rides> trackAuto(@PathVariable Long id) {
        return ridesRepository.findAllByDriverId(id);
    }

    @PostMapping
    @ApiOperation(value = "Add a new ride record")
    public Rides create(@RequestBody final Rides famous5) {

        return ridesRepository.saveAndFlush(famous5);
    }

    @Transactional
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete a ride record")
    public void delete(@PathVariable Long id) {
        //wont delete children records
        ridesRepository.deleteAllByDriverId(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update details of a ride record")
    public Rides update(@PathVariable Long id, @RequestBody Rides famous5) {
        Rides existingFamous5 = ridesRepository.getOne(id);
        BeanUtils.copyProperties(famous5, existingFamous5, "id");
        return ridesRepository.saveAndFlush(existingFamous5);
    }

    @GetMapping("/nextStop")
    @ApiOperation(value = "Find the closest stop for getting an e-rickshaw")
    public ChooseAutoResponse algo() {
        List<AutoStatus> autostatus = autoStatusRepository.findAll();

        Requests request = requestRepository.findFirstByOrderByRequestIdDesc();
        Float minLatitude = request.getSourceLatitude() - autostatus.get(0).getAutoLatitude();
        Float minLongitude = request.getSourceLongitude() - autostatus.get(0).getAutoLongitude();
        Float minDist=(minLatitude*minLatitude)+(minLatitude*minLongitude);
        Float diffLatitude, diffLongitude, actualDist;
        Integer index=0,c=0;

        for (AutoStatus autos : autostatus) {
            diffLatitude = request.getSourceLatitude() - autos.getAutoLatitude();
            diffLongitude = request.getSourceLongitude() - autos.getAutoLongitude();
            actualDist=(diffLatitude*diffLatitude)+(diffLongitude*diffLongitude);

            if (actualDist < minDist){
                minDist=actualDist;
                index=c;
            }
            c++;
        }
        return new ChooseAutoResponse(index+1);
//        return ChooseAutoResponse.builder().autoId(index+1).build();
    }
}