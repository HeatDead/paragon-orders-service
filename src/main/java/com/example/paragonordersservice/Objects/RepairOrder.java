package com.example.paragonordersservice.Objects;

import lombok.Value;

import java.util.Date;

@Value
public class RepairOrder {
    Long id;
    private Long car_id;
    private Date order_date;
}
