package com.tracker.repository;

import org.springframework.stereotype.Repository;
import com.tracker.util.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
