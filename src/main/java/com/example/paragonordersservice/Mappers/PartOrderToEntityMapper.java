package com.example.paragonordersservice.Mappers;

import com.example.paragonordersservice.Entities.PartOrderEntity;
import com.example.paragonordersservice.Objects.PartOrder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PartOrderToEntityMapper {
    PartOrderEntity partOrderToPartOrderEntity(PartOrder partOrder);
    PartOrder partOrderEntityToPartOrder(PartOrderEntity partOrderEntity);
}
