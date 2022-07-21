package com.example.paragonordersservice.Clients;

import com.example.paragonordersservice.Objects.Car;
import com.example.paragonordersservice.Requests.SoldRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(value = "paragon-main-service", url = "http://localhost:8080/")
public interface MainServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "/cars")
    List<Car> getAllCars();

    @RequestMapping(method = RequestMethod.GET, value = "/cars/getCarById")
    Car getCarById(@RequestParam Long id);

    @RequestMapping(method = RequestMethod.POST, value = "/cars/sold/")
    void soldCar(@RequestHeader HttpHeaders request, @RequestBody SoldRequest soldRequest);
}