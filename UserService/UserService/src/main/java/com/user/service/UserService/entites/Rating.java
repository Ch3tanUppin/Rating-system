package com.user.service.UserService.entites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    private String ratingId;

    private String userId;

    private String hotelId;

    private Integer rating;

    private String feedback;

    private Hotel hotel;
    
}
