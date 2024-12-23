package com.hotel.service.HotelService.Service;

import java.util.List;

import com.hotel.service.HotelService.entites.Hotel;

public interface HotelService {
    
    //create
    Hotel create (Hotel hotel);

    //getall
    List<Hotel> getAll();
    
    //getsingle

    Hotel get(String Id);
}
