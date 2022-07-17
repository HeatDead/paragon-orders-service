package com.example.paragonordersservice.Mappers;

import com.example.paragonordersservice.Entities.CarOrderEntity;
import com.example.paragonordersservice.Objects.CarOrder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarOrderToEntityMapper {
    CarOrderEntity carOrderToCarOrderEntity(CarOrder carOrder);
    CarOrder carOrderEntityToCarOrder(CarOrderEntity carOrderEntity);
}
