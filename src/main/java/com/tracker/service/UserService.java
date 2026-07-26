package com.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.repository.UserRepository;
import com.tracker.util.User;
import com.tracker.util.UserRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    @Autowired
    private UserRepository repo;

    public List<User> getUsers(){
        return repo.findAll();
    }

    public void saveUser(UserRequest userReq){
        User user = new User(userReq);
        repo.save(user);
    }

    public User getUserByPhone(String phoneNo) {
        return repo.findByPhoneNo(phoneNo)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
