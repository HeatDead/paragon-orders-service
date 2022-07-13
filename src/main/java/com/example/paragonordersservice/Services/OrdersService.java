package com.example.paragonordersservice.Services;

import org.springframework.http.HttpHeaders;

public interface OrdersService {
    void makeCarOrder(Long id, HttpHeaders request);
    void makeRepairOrder(Long id, HttpHeaders request);
}
