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
    public List<Rides> list() {
        return ridesRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public List<Rides> trackAuto(@PathVariable Long id) {
        return ridesRepository.findAllByDriverId(id);
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public Rides create(@RequestBody final Rides famous5) {

        return ridesRepository.saveAndFlush(famous5);
    }

    @Transactional
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //wont delete children records
        ridesRepository.deleteAllByDriverId(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Rides update(@PathVariable Long id, @RequestBody Rides famous5) {
        Rides existingFamous5 = ridesRepository.getOne(id);
        BeanUtils.copyProperties(famous5, existingFamous5, "id");
        return ridesRepository.saveAndFlush(existingFamous5);
    }

    @GetMapping("/nextStop")
    public ChooseAutoResponse algo() {
        List<AutoStatus> autostatus = autoStatusRepository.findAll();

        Requests request = requestRepository.findFirstByOrderByRequestIdDesc();
        Float minLatitude = request.getSourceLatitude() - autostatus.get(0).getAutoLatitude();
        Float minLongitude = request.getSourceLongitude() - autostatus.get(0).getAutoLongitude();
        Float minDist=(minLatitude*minLatitude)+(minLatitude*minLongitude);
        Float diffLatitude, diffLongitude, actualDist;
        Integer index=0,c=0;

        for (var autos : autostatus) {
            diffLatitude = request.getSourceLatitude() - autos.getAutoLatitude();
            diffLongitude = request.getSourceLongitude() - autos.getAutoLongitude();
            actualDist=(diffLatitude*diffLatitude)+(diffLongitude*diffLongitude);

            if (actualDist < minDist){
                minDist=actualDist;
                index=c;
            }
            c++;
        }
        return ChooseAutoResponse.builder().autoId(index+1).build();
    }
}