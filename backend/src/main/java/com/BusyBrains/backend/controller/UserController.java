package com.BusyBrains.backend.controller;

import com.BusyBrains.backend.entity.User;
import com.BusyBrains.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    // GET PROFILE
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // UPDATE USERNAME
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // CHANGE PASSWORD
    @PutMapping("/{id}/password")
    public User changePassword(@PathVariable Long id, @RequestBody User user) {
        return userService.changePassword(id, user.getPassword());
    }
}