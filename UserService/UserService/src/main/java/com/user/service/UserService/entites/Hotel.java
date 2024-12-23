package com.user.service.UserService.entites;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    private String hotelId;

    private String hotelName;

    private String hotelLocation;

    private String aboutHotel;
}
