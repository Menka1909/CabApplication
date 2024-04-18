package com.example.CabBooking.dto.requestDTO;

import lombok.Getter;

@Getter
public class AddDriverDTO {
    private String name;
    private String gender;
    private int age;
    private VehicleDetailDTO vehicleDetailDTO;
    private LocationDTO locationDTO;
}
