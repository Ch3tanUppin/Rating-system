package com.user.service.UserService.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.service.UserService.entites.Hotel;

@FeignClient(name = "HOTELSERVICE")
public interface HotelService {

    @GetMapping("/Hotels/{hotelId}")
   public Hotel getHotel(@PathVariable String hotelId);
    
}
