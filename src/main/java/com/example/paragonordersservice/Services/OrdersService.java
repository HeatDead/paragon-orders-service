package com.example.paragonordersservice.Services;

import com.example.paragonordersservice.Requests.FinishRepairOrderRequest;
import com.example.paragonordersservice.Requests.PartsOrderRequest;
import com.example.paragonordersservice.Requests.RepairOrderRequest;
import org.springframework.http.HttpHeaders;

public interface OrdersService {
    void makeCarOrder(Long id, HttpHeaders request);
    void makeRepairOrder(RepairOrderRequest repairOrderRequest, HttpHeaders request);
    void finishRepairOrder(FinishRepairOrderRequest finishRepairOrderRequest);
    void makePartsOrder(PartsOrderRequest partsOrderRequest, HttpHeaders request);
}
