package com.devthao.animecenter.controller;

import com.devthao.animecenter.models.entities.User;
import com.devthao.animecenter.models.request.LoginRequest;
import com.devthao.animecenter.models.request.RegisterRequest;
import com.devthao.animecenter.models.response.ResponseData;
import com.devthao.animecenter.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        userService.registerUser(registerRequest);
        return ResponseEntity.ok().body(ResponseData.builder()
                .status(200)
                .data(registerRequest)
                .message("User registered successfully")
                .build());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok().body(ResponseData.builder()
                .status(200)
                .data(userService.loginUser(loginRequest))
                .message("User logged in successfully")
                .build());
    }

}
