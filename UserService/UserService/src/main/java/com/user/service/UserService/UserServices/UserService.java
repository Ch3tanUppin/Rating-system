package com.user.service.UserService.UserServices;

import java.util.List;

import com.user.service.UserService.entites.User;

public interface UserService {
    //useer operatioons
    
    //create users
    User saveUser(User user);

    //get all user
    List<User>getAllUser();

    //get user by id
    User getUser(String userId);
}
