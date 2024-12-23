package com.user.service.UserService.UserServices;
import java.util.*;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.UserService.Repository.UserRepository;
import com.user.service.UserService.entites.Hotel;
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
        .orElseThrow(()-> new ResourceNotFound("User with given id not found"));
        //fetch rating of the above user from rating service
        //url http://localhost:8083/ratings/users/{userId}

        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        logger.info("{}",ratingsOfUser);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
            //api call
            //http://localhost:8082/Hotels/
            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/Hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = forEntity.getBody();
            logger.info("response status code{} ", forEntity.getStatusCode());

            //set the hotel
            rating.setHotel(hotel);

            //return the rating
            return rating;

        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
       
    }
    
}
