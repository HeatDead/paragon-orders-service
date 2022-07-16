package com.example.paragonordersservice.Controllers;

import com.example.paragonordersservice.Objects.RepairOrder;
import com.example.paragonordersservice.Requests.PartsOrderRequest;
import com.example.paragonordersservice.Services.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/repairOrder")
    public void makeRepairOrder(@RequestParam Long car_id, @RequestHeader HttpHeaders request){
        ordersService.makeRepairOrder(car_id, request);
    }

    @PostMapping("/partsOrder")
    public void makePartsOrder(@RequestBody PartsOrderRequest partsOrderRequest, @RequestHeader HttpHeaders request){
        ordersService.makePartsOrder(partsOrderRequest, request);
    }
}