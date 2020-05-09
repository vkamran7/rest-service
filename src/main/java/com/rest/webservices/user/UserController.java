package com.rest.webservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable int id) {
        return service.findOne(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        User savedUser = service.save(user);
    }

}
