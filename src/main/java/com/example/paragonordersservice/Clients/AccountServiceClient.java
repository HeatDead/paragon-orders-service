package com.example.paragonordersservice.Clients;

import com.example.paragonordersservice.Objects.Account;
import com.example.paragonordersservice.Objects.Car;
import com.example.paragonordersservice.Objects.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "paragon-account-service", url = "http://accountService:8081/")
public interface AccountServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "/account")
    Account getAccount(@RequestHeader HttpHeaders request);

    @RequestMapping(method = RequestMethod.POST, value = "/auth/token")
    Object getToken(@RequestBody User user);

    @RequestMapping(method = RequestMethod.GET, value = "/account/cars")
    List<Car> getUserCars(@RequestHeader HttpHeaders request);

    @RequestMapping(method = RequestMethod.GET, value = "/account/checkCar")
    boolean belongCarToUser(@RequestParam Long id, @RequestHeader HttpHeaders request);
}
