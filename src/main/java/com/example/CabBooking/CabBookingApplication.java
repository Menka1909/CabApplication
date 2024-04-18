package com.example.CabBooking;

import com.example.CabBooking.model.Driver;
import com.example.CabBooking.model.User;
import com.example.CabBooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableWebMvc
public class CabBookingApplication {

	public static List<User> userList = new ArrayList<>();
	public static List<Driver> driverDetailList = new ArrayList<>();
	public static void main(String[] args) {
		SpringApplication.run(CabBookingApplication.class, args);
	}

}
