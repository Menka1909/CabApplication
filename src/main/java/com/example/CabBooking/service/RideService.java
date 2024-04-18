package com.example.CabBooking.service;

import com.example.CabBooking.CabBookingApplication;
import com.example.CabBooking.dto.requestDTO.FindRideDTO;
import com.example.CabBooking.dto.requestDTO.LocationDTO;
import com.example.CabBooking.exception.DriverNotFoundException;
import com.example.CabBooking.exception.UserNotValidException;
import com.example.CabBooking.model.Driver;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RideService {

    public List<Driver> findRide(FindRideDTO findRideDTO) throws DriverNotFoundException, UserNotValidException {
        String userName = findRideDTO.getUserName();
        if(!userValid(userName)){
            throw new UserNotValidException("User does not exist in the application");
        }

        List<Driver> availableDrivers = CabBookingApplication.driverDetailList.stream()
                                        .filter(Driver::isAvailable)
                                        .collect(Collectors.toList());

        List<Driver> driverListWithMinDistance = findDriversWithinRange(findRideDTO.getSource(), availableDrivers);

        if(availableDrivers.isEmpty() || driverListWithMinDistance.isEmpty()) {
            throw new DriverNotFoundException("No ride found as drivers are not available " +
                    "or all the drivers are more than 5 units away");
        }

        return driverListWithMinDistance;
    }

    private boolean userValid(String userName) {
        return CabBookingApplication.userList.stream()
                .anyMatch(user -> userName.equals(user.getName()));
    }

    private List<Driver> findDriversWithinRange(LocationDTO source, List<Driver> availableDrivers) {
        return availableDrivers.stream()
                .filter(driver -> isDriverWithinRange(source, driver)).collect(Collectors.toList());
    }

    private boolean isDriverWithinRange(LocationDTO source, Driver driver) {
        double deltaX = driver.getLocation().getX() - source.getX();
        double deltaY = driver.getLocation().getY() - source.getY();
        double distanceSquared = deltaX * deltaX + deltaY * deltaY;
        return distanceSquared <= 25;
    }

}
