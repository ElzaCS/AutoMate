package com.example.automate.controllers;

import com.example.automate.models.AutoStatus;
import com.example.automate.repositories.AutoStatusRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autoStatus")
public class AutoStatusController {

    @Autowired
    private AutoStatusRepository autoStatusRepository;

    @GetMapping
    @ApiOperation(value = "List the current status of all rickshaws")
    public List<AutoStatus> list() {
        return autoStatusRepository.findAll();
    }

    @ApiOperation(value = "Update status of a rickshaw")
    @PostMapping(value = "/{id}")
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public AutoStatus update(@PathVariable Long id, @RequestBody AutoStatus autoStatus) {
        AutoStatus existingAutoStatus = autoStatusRepository.getOne(id);
        BeanUtils.copyProperties(autoStatus, existingAutoStatus, "id");
        return autoStatusRepository.saveAndFlush(existingAutoStatus);
    }

    @ApiOperation(value = "Get status of a rickshaw")
    @GetMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AutoStatus get(@PathVariable Long id) {
        return autoStatusRepository.getOne(id);
    }

}
