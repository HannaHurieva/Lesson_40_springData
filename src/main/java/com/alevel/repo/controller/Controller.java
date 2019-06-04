package com.alevel.repo.controller;

import com.alevel.repo.dto.User;
import com.alevel.repo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class Controller {

    private final UserService userService;

    @Autowired
    public Controller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/save")
    public ResponseEntity getUser(@RequestParam String name){
        User user = new User();
        user.setName(name);
        userService.save(user);
        return ResponseEntity.ok("Hello, " + name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        userService.save(user);
        return user;
    }
}
