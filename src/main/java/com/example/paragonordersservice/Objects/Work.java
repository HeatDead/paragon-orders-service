package com.example.paragonordersservice.Objects;

import lombok.Data;

@Data
public class Work {
    Long id;

    Long order_id;

    String description;

    Double price;
    Double total_price;
}
