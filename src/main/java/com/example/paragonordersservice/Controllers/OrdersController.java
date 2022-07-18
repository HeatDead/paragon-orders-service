package com.example.paragonordersservice.Controllers;

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

    @PostMapping("/carOrder")
    public void makeCarOrder(@RequestParam Long car_id, @RequestHeader HttpHeaders request){
        ordersService.makeCarOrder(car_id, request);
    }

    @GetMapping("/carOrders")
    public List<CarOrder> getCarOrders(){
        return ordersService.getCarOrders();
    }

    @PostMapping("/repairOrder")
    public void makeRepairOrder(@RequestBody RepairOrderRequest repairOrderRequest, @RequestHeader HttpHeaders request){
        ordersService.makeRepairOrder(repairOrderRequest, request);
    }

    @PostMapping("/finishRepairOrder")
    public void finishRepairOrder(@RequestBody FinishRepairOrderRequest finishRepairOrderRequest){
        ordersService.finishRepairOrder(finishRepairOrderRequest);
    }

    @GetMapping("/repairOrders")
    public List<RepairOrder> getRepairOrders(){
        return ordersService.getRepairOrders(false);
    }

    @GetMapping("/repairOrderById")
    public List<RepairOrder> getRepairOrderById(@RequestParam Long id){
        return getRepairOrderById(id);
    }

    @GetMapping("/finishedRepairOrders")
    public List<RepairOrder> getFinishedRepairOrders(){
        return ordersService.getRepairOrders(true);
    }

    @PostMapping("/partsOrder")
    public void makePartsOrder(@RequestBody PartsOrderRequest partsOrderRequest, @RequestHeader HttpHeaders request){
        ordersService.makePartsOrder(partsOrderRequest, request);
    }

    @GetMapping("/partOrders")
    public List<PartOrder> getPartOrders(){
        return ordersService.getPartOrders();
    }
}