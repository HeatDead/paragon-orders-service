package com.example.paragonordersservice.Clients;

import com.example.paragonordersservice.Objects.Part;
import com.example.paragonordersservice.Objects.Work;
import com.example.paragonordersservice.Requests.PartRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "paragon-sto-service", url = "http://localhost:8083/")
public interface StoServiceClient {
    @RequestMapping(method = RequestMethod.POST, value = "/parts/order")
    void orderPart(@RequestBody PartRequest partRequest);

    @RequestMapping(method = RequestMethod.GET, value = "/parts")
    Part getPartById(@RequestParam Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/works")
    List<Work> getWorksByOrderId(@RequestParam Long order_id);
}
