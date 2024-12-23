package com.hotel.service.HotelService.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.service.HotelService.Exception.ResourceNotFound;
import com.hotel.service.HotelService.Repository.HotelRepository;
import com.hotel.service.HotelService.entites.Hotel;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setHotelId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {        
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String Id) {
        return hotelRepository.findById(Id).orElseThrow(()-> new ResourceNotFound("Hotel with given id not found"));
    }

    
    
}
