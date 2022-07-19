package com.example.paragonordersservice.Controllers;

import com.example.paragonordersservice.Exceptions.IncorrectOrderException;
import com.example.paragonordersservice.Exceptions.ObjectNotFoundException;
import com.example.paragonordersservice.Objects.CarOrder;
import com.example.paragonordersservice.Objects.PartOrder;
import com.example.paragonordersservice.Objects.RepairOrder;
import com.example.paragonordersservice.Requests.FinishRepairOrderRequest;
import com.example.paragonordersservice.Requests.PartsOrderRequest;
import com.example.paragonordersservice.Requests.RepairOrderRequest;
import com.example.paragonordersservice.Services.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersService ordersService;

    @RequestMapping(value = "/carOrder", method = RequestMethod.POST)
    public void makeCarOrder(@RequestParam Long car_id, @RequestHeader HttpHeaders request) throws IncorrectOrderException {
        ordersService.makeCarOrder(car_id, request);
    }

    @RequestMapping(value = "/carOrders", method = RequestMethod.GET)
    public List<CarOrder> getCarOrders(){
        return ordersService.getCarOrders();
    }

    @RequestMapping(value = "/repairOrder", method = RequestMethod.POST)
    public void makeRepairOrder(@RequestBody RepairOrderRequest repairOrderRequest, @RequestHeader HttpHeaders request) throws IncorrectOrderException{
        ordersService.makeRepairOrder(repairOrderRequest, request);
    }

    @RequestMapping(value = "/finishRepairOrder", method = RequestMethod.PUT)
    public void finishRepairOrder(@RequestBody FinishRepairOrderRequest finishRepairOrderRequest) throws ObjectNotFoundException {
        ordersService.finishRepairOrder(finishRepairOrderRequest);
    }

    @RequestMapping(value = "/repairOrders", method = RequestMethod.GET)
    public List<RepairOrder> getRepairOrders(){
        return ordersService.getRepairOrders(false);
    }

    @RequestMapping(value = "/repairOrderById", method = RequestMethod.GET)
    public RepairOrder getRepairOrderById(@RequestParam Long id) throws ObjectNotFoundException{
        return ordersService.getRepairOrderById(id);
    }

    @RequestMapping(value = "/finishedRepairOrders", method = RequestMethod.GET)
    public List<RepairOrder> getFinishedRepairOrders(){
        return ordersService.getRepairOrders(true);
    }

    @RequestMapping(value = "/partsOrder", method = RequestMethod.POST)
    public void makePartsOrder(@RequestBody PartsOrderRequest partsOrderRequest, @RequestHeader HttpHeaders request) throws ObjectNotFoundException{
        ordersService.makePartsOrder(partsOrderRequest, request);
    }

    @RequestMapping(value = "/partOrders", method = RequestMethod.GET)
    public List<PartOrder> getPartOrders(){
        return ordersService.getPartOrders();
    }
}