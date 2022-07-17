package com.example.paragonordersservice.Mappers;

import com.example.paragonordersservice.Entities.RepairOrderEntity;
import com.example.paragonordersservice.Objects.RepairOrder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RepairOrderToEntityMapper {
    RepairOrderEntity repairOrderToRepairOrderEntity(RepairOrder repairOrder);
    RepairOrder repairOrderEntityToRepairOrder(RepairOrderEntity repairOrderEntity);
}
