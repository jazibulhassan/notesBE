package com.jazib.petprojects.notesBE.controller;

import com.jazib.petprojects.notesBE.exception.ResourceNotFoundException;
import com.jazib.petprojects.notesBE.model.User;
import com.jazib.petprojects.notesBE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        return userService.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

}
