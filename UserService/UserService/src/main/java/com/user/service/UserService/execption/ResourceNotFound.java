package com.user.service.UserService.execption;

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(){
        super("Not found on serve");
    }

    public ResourceNotFound(String message){
        super(message);
    }
    
}
