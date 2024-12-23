package com.user.rating.RatingService.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.user.rating.RatingService.entites.Rating;
import java.util.List;


public interface RatingRepository extends MongoRepository<Rating, String>{
    //custom finder method
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
    
}
