package com.example.CabBooking.controllers;

import com.example.CabBooking.dto.requestDTO.FindRideDTO;
import com.example.CabBooking.exception.DriverNotFoundException;
import com.example.CabBooking.exception.UserNotValidException;
import com.example.CabBooking.model.Driver;
import com.example.CabBooking.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RideController {

    @Autowired
    private RideService rideService;

    @PostMapping("/ride/find")
    public List<Driver> findRide(@RequestBody FindRideDTO findRideDTO) throws DriverNotFoundException, UserNotValidException {
        return rideService.findRide(findRideDTO);
    }

}
