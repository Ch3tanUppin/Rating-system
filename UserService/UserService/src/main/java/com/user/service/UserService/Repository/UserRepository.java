package com.user.service.UserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.service.UserService.entites.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
}
