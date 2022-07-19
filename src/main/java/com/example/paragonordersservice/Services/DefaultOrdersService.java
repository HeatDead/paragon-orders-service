package com.example.paragonordersservice.Services;

import com.example.paragonordersservice.Clients.AccountServiceClient;
import com.example.paragonordersservice.Clients.MainServiceClient;
import com.example.paragonordersservice.Clients.StoServiceClient;
import com.example.paragonordersservice.Entities.CarOrderEntity;
import com.example.paragonordersservice.Entities.PartOrderEntity;
import com.example.paragonordersservice.Entities.RepairOrderEntity;
import com.example.paragonordersservice.Mappers.CarOrderToEntityMapper;
import com.example.paragonordersservice.Mappers.PartOrderToEntityMapper;
import com.example.paragonordersservice.Mappers.RepairOrderToEntityMapper;
import com.example.paragonordersservice.Objects.*;
import com.example.paragonordersservice.Repositories.CarOrderRepository;
import com.example.paragonordersservice.Repositories.PartOrderRepository;
import com.example.paragonordersservice.Repositories.RepairOrderRepository;
import com.example.paragonordersservice.Requests.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.http.HttpHeaders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultOrdersService implements OrdersService {
    private final MainServiceClient mainServiceClient;
    private final AccountServiceClient accountServiceClient;
    private final StoServiceClient stoServiceClient;

    private final CarOrderRepository carOrderRepository;
    private final RepairOrderRepository repairOrderRepository;
    private final PartOrderRepository partOrderRepository;

    private final PartOrderToEntityMapper partOrderToEntityMapper;
    private final RepairOrderToEntityMapper repairOrderToEntityMapper;
    private final CarOrderToEntityMapper carOrderToEntityMapper;

    @Override
    public void makeCarOrder(Long id, HttpHeaders request) {
        try {
            Car car = mainServiceClient.getCarById(id);
            Account account = accountServiceClient.getAccount(request);

            if(car == null || account == null || car.isSold())
                throw new Exception("Error when creating an order : " + car + " " + account + " " + car.isSold());

            System.out.println("Making car order: User: " + account.getUsername() + ", Car: " + car.getId());

            SoldRequest soldRequest = new SoldRequest();
            soldRequest.setUsername(account.getUsername());
            soldRequest.setCar_id(id);

            mainServiceClient.soldCar(getHeader(), soldRequest);
            CarOrderEntity carOrderEntity = new CarOrderEntity();
            carOrderEntity.setCar_id(id);
            carOrderEntity.setUser_id(account.getUsername());
            carOrderEntity.setOrder_date(new Date());
            carOrderRepository.save(carOrderEntity);

        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @Override
    public List<CarOrder> getCarOrders() {
        Iterable<CarOrderEntity> iterable = carOrderRepository.findAll();

        List<CarOrder> carOrders = new ArrayList<>();
        for (CarOrderEntity entity : iterable){
            carOrders.add(carOrderToEntityMapper.carOrderEntityToCarOrder(entity));
        }

        return carOrders;
    }

    @Override
    public void makeRepairOrder(RepairOrderRequest repairOrderRequest, HttpHeaders request) {
        try {
            Car car = mainServiceClient.getCarById(repairOrderRequest.getCar_id());
            Account account = accountServiceClient.getAccount(request);

            //TODO: проверка принадлежности авто
            if(car == null || account == null)
                throw new Exception("Error when creating an order");

            System.out.println("Making repair order: User: " + account.getUsername() + ", Car: " + car.getId());

            RepairOrderEntity repairOrderEntity = new RepairOrderEntity();

            repairOrderEntity.setCar_id(repairOrderRequest.getCar_id());
            repairOrderEntity.setUser_id(account.getUsername());
            repairOrderEntity.setOrder_date(new Date());
            repairOrderEntity.setDescription(repairOrderRequest.getDescription());
            repairOrderEntity.setWork_type(repairOrderRequest.getWork_type());

            repairOrderRepository.save(repairOrderEntity);
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

    private HttpHeaders getHeader(){
        HttpHeaders header = new HttpHeaders();
        String s = accountServiceClient.getToken(new User("microservice", "microservice")).toString();
        s = s.substring(7, s.length() - 1);
        System.out.println(s);
        header.add(HttpHeaders.AUTHORIZATION, "Bearer " + s);
        return header;
    }

    @Override
    public void finishRepairOrder(FinishRepairOrderRequest finishRepairOrderRequest) {
        RepairOrderEntity entity = repairOrderRepository.findById(finishRepairOrderRequest.getId()).get();

        entity.setResult(finishRepairOrderRequest.getResult());
        entity.setFinish_date(new Date());

        List<Work> works = stoServiceClient.getWorksByOrderId(getHeader(), finishRepairOrderRequest.getId());

        Double total_price = 0.0;
        for(Work w : works)
            total_price += w.getTotal_price();

        entity.setPrice(total_price);

        repairOrderRepository.save(entity);
    }

    @Override
    public List<RepairOrder> getRepairOrders(boolean state) {
        Iterable<RepairOrderEntity> iterable = repairOrderRepository.findAll();

        List<RepairOrder> repairOrders = new ArrayList<>();
        for (RepairOrderEntity entity : iterable){
            if(state)
                if (entity.getFinish_date() == null)
                    continue;
            if(!state)
                if (entity.getFinish_date() != null)
                    continue;
            repairOrders.add(repairOrderToEntityMapper.repairOrderEntityToRepairOrder(entity));
        }

        return repairOrders;
    }

    @Override
    public RepairOrder getRepairOrderById(Long id) {
        return repairOrderToEntityMapper.repairOrderEntityToRepairOrder(repairOrderRepository.findById(id).get());
    }

    @Override
    public void makePartsOrder(PartsOrderRequest partsOrderRequest, HttpHeaders request) {
        try {
            Account account = accountServiceClient.getAccount(request);

            if(account == null)
                return;

            PartOrderEntity entity = new PartOrderEntity();
            entity.setUser_id(account.getUsername());
            entity.setOrder_date(new Date());

            double price = 0;
            System.out.println(partsOrderRequest.getPartRequests());
            for (PartRequest pq : partsOrderRequest.getPartRequests()){
                price += stoServiceClient.getPartById(getHeader(), pq.getId()).getPrice() * pq.getCount();
                stoServiceClient.orderPart(getHeader(), pq);
            }

            entity.setPrice(price);
            partOrderRepository.save(entity);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public List<PartOrder> getPartOrders() {
        Iterable<PartOrderEntity> iterable = partOrderRepository.findAll();

        List<PartOrder> partOrders = new ArrayList<>();
        for (PartOrderEntity entity : iterable){
            partOrders.add(partOrderToEntityMapper.partOrderEntityToPartOrder(entity));
        }

        return partOrders;
    }
}