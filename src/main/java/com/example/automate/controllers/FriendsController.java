package com.example.automate.controllers;

import com.example.automate.models.Friends;
import com.example.automate.repositories.FriendsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friends")
public class FriendsController {
    @Autowired
    private FriendsRepository friendsRepository;

    @GetMapping
    public List<Friends> list() {
        return friendsRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Friends get(@PathVariable Long id) {
        return friendsRepository.getOne(id);
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public Friends create(@RequestBody final Friends famous5) {
        return friendsRepository.saveAndFlush(famous5);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //wont delete children records
        friendsRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Friends update(@PathVariable Long id, @RequestBody Friends famous5) {
        Friends existingFamous5 = friendsRepository.getOne(id);
        BeanUtils.copyProperties(famous5, existingFamous5, "id");
        return friendsRepository.saveAndFlush(existingFamous5);
    }
}