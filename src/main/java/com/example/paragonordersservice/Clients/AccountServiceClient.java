package com.example.paragonordersservice.Clients;

import com.example.paragonordersservice.Objects.Account;
import com.example.paragonordersservice.Objects.User;
import com.example.paragonordersservice.Responses.TokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "paragon-account-service", url = "http://localhost:8081/")
public interface AccountServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "/account")
    Account getAccount(@RequestHeader HttpHeaders request);

    @RequestMapping(method = RequestMethod.POST, value = "/auth/token")
    Object getToken(@RequestBody User user);

    @RequestMapping(method = RequestMethod.GET, value = "/account/cars")
    Object getUserCars(@RequestHeader HttpHeaders request);
}
