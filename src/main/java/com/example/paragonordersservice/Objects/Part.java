package com.example.paragonordersservice.Objects;

import lombok.Data;

@Data
public class Part {
    Long id;

    String name;
    Long brand_id;
    Long model_id;

    Double price;
}
