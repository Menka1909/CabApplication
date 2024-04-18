package com.example.CabBooking.service;

import com.example.CabBooking.CabBookingApplication;
import com.example.CabBooking.dto.requestDTO.AddUserDTO;
import com.example.CabBooking.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class UserService {

    public User addUser(AddUserDTO userDTO) {
        User user = new User();
        user.setId(generateId());
        user.setName(userDTO.getName());
        user.setGender(userDTO.getGender());
        user.setAge(userDTO.getAge());
        user.setCreatedAt(LocalDate.now());
        CabBookingApplication.userList.add(user);
        return user;
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }

}
