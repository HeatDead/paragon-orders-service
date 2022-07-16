package com.example.paragonordersservice.Repositories;

import com.example.paragonordersservice.Entities.PartOrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface PartOrderRepository extends CrudRepository<PartOrderEntity, Long> {
}
