package com.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.service.UserService;
import com.tracker.util.User;
import com.tracker.util.UserRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
        
    @Autowired
    private UserService service;
    
    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return service.getUsers();
    }

    @PostMapping("/newUser")
    public ResponseEntity<Void> submitUser(
            @RequestBody UserRequest request) {

        service.saveUser(request);
        return ResponseEntity.accepted().build();
    }
}
