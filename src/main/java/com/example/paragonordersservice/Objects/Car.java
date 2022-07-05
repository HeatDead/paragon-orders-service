package com.example.paragonordersservice.Objects;

import lombok.Value;

@Value
public class Car {
    Long id;
    String name;
    int year;
    Double price;
}
