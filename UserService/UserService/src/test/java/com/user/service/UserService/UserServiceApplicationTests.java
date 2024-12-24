package com.user.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.user.service.UserService.entites.Rating;
import com.user.service.UserService.external.service.RatingService;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;

	/**@Test
	public void createRating(){

		Rating rating = Rating.builder().rating(10).userId("")
		.hotelId("").feedback("This is created using open fein client").build();

		Rating savedRating = ratingService.createRating(rating);

		System.out.println("New rating created");


	}**/

}
