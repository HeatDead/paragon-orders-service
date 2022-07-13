package com.example.paragonordersservice.Repositories;

import com.example.paragonordersservice.Entities.RepairOrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface RepairOrderRepository extends CrudRepository<RepairOrderEntity, Long> {
}
