package com.example.paragonordersservice.Requests;

import lombok.Data;

import java.util.List;

@Data
public class PartsOrderRequest {
    List<PartRequest> partRequests;
}
