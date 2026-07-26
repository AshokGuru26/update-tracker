package com.tracker.util;

import java.time.LocalDateTime;

import com.tracker.service.LocationService;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone_no", nullable = false)
    private String phoneNo;

    private String gaurdian;

    private String gaurdPhoneNo;

    public User(UserRequest req){
        this.name = req.name();
        this.phoneNo = req.phoneNo();
        this.gaurdian = req.gaurdian();
        this.gaurdPhoneNo = req.gaurdPhoneNo();
    }
}
