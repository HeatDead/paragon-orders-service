package com.example.paragonordersservice.Services;

import com.example.paragonordersservice.Exceptions.IncorrectOrderException;
import com.example.paragonordersservice.Exceptions.ObjectNotFoundException;
import com.example.paragonordersservice.Objects.CarOrder;
import com.example.paragonordersservice.Objects.PartOrder;
import com.example.paragonordersservice.Objects.RepairOrder;
import com.example.paragonordersservice.Requests.FinishRepairOrderRequest;
import com.example.paragonordersservice.Requests.PartsOrderRequest;
import com.example.paragonordersservice.Requests.RepairOrderRequest;
import org.springframework.http.HttpHeaders;

import java.util.List;

public interface OrdersService {
    void makeCarOrder(Long id, HttpHeaders request) throws IncorrectOrderException;
    List<CarOrder> getCarOrders();
    void makeRepairOrder(RepairOrderRequest repairOrderRequest, HttpHeaders request) throws IncorrectOrderException;
    void finishRepairOrder(FinishRepairOrderRequest finishRepairOrderRequest) throws ObjectNotFoundException, Exception, IncorrectOrderException;
    List<RepairOrder> getRepairOrders(boolean state);
    RepairOrder getRepairOrderById(Long id) throws ObjectNotFoundException;
    void makePartsOrder(PartsOrderRequest partsOrderRequest, HttpHeaders request) throws ObjectNotFoundException;
    List<PartOrder> getPartOrders();
}
