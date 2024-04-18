package com.example.CabBooking.controllers;

import com.example.CabBooking.dto.requestDTO.AddUserDTO;
import com.example.CabBooking.model.User;
import com.example.CabBooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/add")
    public User addUser(@RequestBody AddUserDTO userDTO) {
        return userService.addUser(userDTO);
    }

}
