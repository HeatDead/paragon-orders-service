package com.example.paragonordersservice.Repositories;

import com.example.paragonordersservice.Entities.CarEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<CarEntity, Long> {
    List<CarEntity> findAllByNameContaining(String name);
}
