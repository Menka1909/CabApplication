package com.example.CabBooking.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Location {
    private int x;
    private int y;
}
