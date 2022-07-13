package com.example.paragonordersservice.Repositories;

import com.example.paragonordersservice.Entities.CarOrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface CarOrderRepository extends CrudRepository<CarOrderEntity, Long> {
}
