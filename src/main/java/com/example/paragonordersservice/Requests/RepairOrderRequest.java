package com.example.paragonordersservice.Requests;

import lombok.Data;

@Data
public class RepairOrderRequest {
    Long car_id;
    String description;
    Long work_type;
}
