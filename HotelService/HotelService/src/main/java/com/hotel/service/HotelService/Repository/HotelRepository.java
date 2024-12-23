package com.hotel.service.HotelService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.service.HotelService.entites.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String>{
    
}
