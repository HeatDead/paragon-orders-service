package com.example.paragonordersservice.Mappers;

import com.example.paragonordersservice.Objects.Car;
import com.example.paragonordersservice.Requests.CarRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarToDtoMapper {
    Car AddCarRequestToCar(CarRequest carRequest);
}
