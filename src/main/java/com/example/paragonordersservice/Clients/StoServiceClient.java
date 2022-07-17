package com.example.paragonordersservice.Clients;

import com.example.paragonordersservice.Objects.Part;
import com.example.paragonordersservice.Objects.Work;
import com.example.paragonordersservice.Requests.PartRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "paragon-sto-service", url = "http://localhost:8083/")
public interface StoServiceClient {
    @RequestMapping(method = RequestMethod.POST, value = "/parts/order")
    void orderPart(@RequestHeader HttpHeaders request, @RequestBody PartRequest partRequest);

    @RequestMapping(method = RequestMethod.GET, value = "/parts/getPartById")
    Part getPartById(@RequestHeader HttpHeaders request, @RequestParam Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/works")
    List<Work> getWorksByOrderId(@RequestHeader HttpHeaders request, @RequestParam Long order_id);
}
