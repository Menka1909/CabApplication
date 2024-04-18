package com.example.CabBooking.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class User {
    private String id;
    private String name;
    private String gender;
    private int age;
    private LocalDate createdAt;
}
