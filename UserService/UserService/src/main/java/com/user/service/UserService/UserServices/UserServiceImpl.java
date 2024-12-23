package com.user.service.UserService.UserServices;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.UserService.Repository.UserRepository;
import com.user.service.UserService.entites.Rating;
import com.user.service.UserService.entites.User;
import com.user.service.UserService.execption.ResourceNotFound;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    
    private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
        
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
        
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId)
        .orElseThrow(()-> new ResourceNotFound("USer with given id not found"));
        //fetch rating of the above user from rating service
        //url http://localhost:8083/ratings/users/{userId}

        ArrayList<Rating> ratingsOfUser = restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getUserId(), ArrayList.class);
        logger.info("{}",ratingsOfUser);

        user.setRatings(ratingsOfUser);
        return user;
       
    }
    
}