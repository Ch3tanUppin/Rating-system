package com.user.service.UserService.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.user.service.UserService.entites.Rating;

@Service
@FeignClient(name = "RATINGSERVICE")
public interface RatingService {
    
    //get



    //post
    @PostMapping("/ratings")
    public ResponseEntity<Rating> createRating(Rating values);


    //delete
    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRatig(@PathVariable String ratingId);


    //put
    @PutMapping("/ratings/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable String ratingId);
    
}
