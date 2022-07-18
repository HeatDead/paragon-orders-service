package com.example.paragonordersservice.Services;

import com.example.paragonordersservice.Objects.CarOrder;
import com.example.paragonordersservice.Objects.PartOrder;
import com.example.paragonordersservice.Objects.RepairOrder;
import com.example.paragonordersservice.Requests.FinishRepairOrderRequest;
import com.example.paragonordersservice.Requests.PartsOrderRequest;
import com.example.paragonordersservice.Requests.RepairOrderRequest;
import org.springframework.http.HttpHeaders;

import java.util.List;

public interface OrdersService {
    void makeCarOrder(Long id, HttpHeaders request);
    List<CarOrder> getCarOrders();
    void makeRepairOrder(RepairOrderRequest repairOrderRequest, HttpHeaders request);
    void finishRepairOrder(FinishRepairOrderRequest finishRepairOrderRequest);
    List<RepairOrder> getRepairOrders(boolean state);
    RepairOrder getRepairOrderById(Long id);
    void makePartsOrder(PartsOrderRequest partsOrderRequest, HttpHeaders request);
    List<PartOrder> getPartOrders();
}
