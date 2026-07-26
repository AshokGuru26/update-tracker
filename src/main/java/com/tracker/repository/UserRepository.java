package com.tracker.repository;

import org.springframework.stereotype.Repository;
import com.tracker.util.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPhoneNo(String phoneNo);
}
