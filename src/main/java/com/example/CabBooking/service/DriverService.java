package com.example.CabBooking.service;

import com.example.CabBooking.CabBookingApplication;
import com.example.CabBooking.dto.requestDTO.AddDriverDTO;
import com.example.CabBooking.model.Driver;
import com.example.CabBooking.model.Location;
import com.example.CabBooking.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DriverService {

    public Driver addDriver(AddDriverDTO driverDTO) {
        Vehicle vehicle = Vehicle.builder()
                            .model(driverDTO.getVehicleDetailDTO().getVehicleModel())
                            .vehicleNumber(driverDTO.getVehicleDetailDTO().getVehicleNumber())
                            .build();

        Location location = Location.builder()
                                .x(driverDTO.getLocationDTO().getX())
                                .y(driverDTO.getLocationDTO().getY())
                                .build();

        Driver driverDetail = Driver.builder().id(generateId())
                .gender(driverDTO.getGender())
                .age(driverDTO.getAge())
                .vehicle(vehicle)
                .location(location)
                .build();

        List<Driver> driverDetailList = CabBookingApplication.driverDetailList;
        driverDetailList.add(driverDetail);

        return driverDetail;
    }

    public String generateId() {
        return UUID.randomUUID().toString();
    }

}
