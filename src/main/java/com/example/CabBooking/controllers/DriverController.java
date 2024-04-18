package com.example.CabBooking.controllers;

import com.example.CabBooking.dto.requestDTO.AddDriverDTO;
import com.example.CabBooking.model.Driver;
import com.example.CabBooking.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/driver/add")
    public Driver addDriver(@RequestBody AddDriverDTO driverDTO) {
        return driverService.addDriver(driverDTO);
    }

}
