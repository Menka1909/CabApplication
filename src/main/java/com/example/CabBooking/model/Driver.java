package com.example.CabBooking.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Driver {
    private String id;
    private String name;
    private String gender;
    private int age;
    private Vehicle vehicle;
    private Location location;
    @Builder.Default
    private boolean available = true;
}
