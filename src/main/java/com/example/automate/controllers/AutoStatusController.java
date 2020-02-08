package com.example.automate.controllers;

import com.example.automate.models.AutoStatus;
import com.example.automate.repositories.AutoStatusRepository;
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
    public List<AutoStatus> list() {
        return autoStatusRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public AutoStatus update(@PathVariable Long id, @RequestBody AutoStatus autoStatus) {
        AutoStatus existingAutoStatus = autoStatusRepository.getOne(id);
        BeanUtils.copyProperties(autoStatus, existingAutoStatus, "id");
        return autoStatusRepository.saveAndFlush(existingAutoStatus);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public AutoStatus get(@PathVariable Long id) {
        return autoStatusRepository.getOne(id);
    }

}
