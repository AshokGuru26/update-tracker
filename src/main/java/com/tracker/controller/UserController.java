package com.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.service.UserService;
import com.tracker.util.User;
import com.tracker.util.UserRequest;
import com.tracker.util.UserResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UserController {
        
    @Autowired
    private UserService service;
    
    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return service.getUsers();
    }

    @PostMapping("/newUser")
    public ResponseEntity<UserResponse> submitUser(
            @RequestBody UserRequest request) {

        try{
            User savedUser = service.saveUser(request);

            return ResponseEntity.accepted()
                    .body(new UserResponse(
                        savedUser.getUserId(),
                        "User saved successfully"
                    ));
        } catch(Exception e){
                        return ResponseEntity.accepted()
                    .body(new UserResponse(
                        null,
                        "User saved successfully"
                    ));
        }
    }

    @GetMapping("/user/{phoneNo}")
    public ResponseEntity<User> getUser(@PathVariable String phoneNo) {
        return ResponseEntity.ok(
            service.getUserByPhone(phoneNo)
        );
    }
}
