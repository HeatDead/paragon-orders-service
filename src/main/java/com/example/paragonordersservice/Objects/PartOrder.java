package com.example.paragonordersservice.Objects;

import lombok.Data;

import java.util.Date;

@Data
public class PartOrder {
    Long id;

    String user_id;

    Date order_date;

    Double price;
}
