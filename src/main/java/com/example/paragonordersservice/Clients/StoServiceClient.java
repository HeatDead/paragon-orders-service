package com.example.paragonordersservice.Clients;

import com.example.paragonordersservice.Requests.PartRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "paragon-sto-service", url = "http://localhost:8083/")
public interface StoServiceClient {
    @RequestMapping(method = RequestMethod.POST, value = "/parts")
    void addPart(@RequestBody PartRequest partRequest);
}
