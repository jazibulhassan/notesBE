package com.jazib.petprojects.notesBE.controller;

import com.jazib.petprojects.notesBE.dto.LoginRequest;
import com.jazib.petprojects.notesBE.model.User;
import com.jazib.petprojects.notesBE.security.JwtService;
import com.jazib.petprojects.notesBE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest loginRequest) {
        UserDetails user = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        String token = jwtService.generateToken(user);
        return Map.of("token", token);
    }

}
