package com.example.paragonordersservice.Objects;

import lombok.Value;

import java.util.Date;

@Value
public class RepairOrder {
    Long id;
    Long car_id;
    Date order_date;
    String result;
}
