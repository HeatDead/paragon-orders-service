package com.example.paragonordersservice.Objects;

import lombok.Value;

import java.util.Date;

@Value
public class CarOrder {
    private Long id;
    private Long car_id;
    private Date order_date;
}
