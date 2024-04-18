package com.example.CabBooking.dto.requestDTO;

import lombok.Getter;

@Getter
public class FindRideDTO {
    private String userName;
    private LocationDTO source;
    private LocationDTO destination;
}
