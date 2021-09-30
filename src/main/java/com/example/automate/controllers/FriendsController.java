package com.example.automate.controllers;

import com.example.automate.models.Friends;
import com.example.automate.repositories.FriendsRepository;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "List all friends")
    public List<Friends> list() {
        return friendsRepository.findAll();
    }

    @GetMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get details of a friend account")
    public Friends get(@PathVariable Long id) {
        return friendsRepository.getOne(id);
    }

    @PostMapping
    @ApiOperation(value = "Add a friend")
    public Friends create(@RequestBody final Friends famous5) {
        return friendsRepository.saveAndFlush(famous5);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Remove a friend")
    public void delete(@PathVariable Long id) {
        //wont delete children records
        friendsRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update a friend's record")
    public Friends update(@PathVariable Long id, @RequestBody Friends famous5) {
        Friends existingFamous5 = friendsRepository.getOne(id);
        BeanUtils.copyProperties(famous5, existingFamous5, "id");
        return friendsRepository.saveAndFlush(existingFamous5);
    }
}