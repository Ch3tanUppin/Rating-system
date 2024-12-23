package com.hotel.service.HotelService.Exception;

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(String s){
        super(s);
    }

    public ResourceNotFound(){
        super("Resource Not Found");
    }
    
}