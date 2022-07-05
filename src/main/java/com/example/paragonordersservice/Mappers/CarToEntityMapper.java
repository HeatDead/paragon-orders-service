package com.example.paragonordersservice.Mappers;

import com.example.paragonordersservice.Entities.CarEntity;
import com.example.paragonordersservice.Objects.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarToEntityMapper {
    CarEntity carToCarEntity(Car book);
    Car carEntityToCar(CarEntity bookEntity);
}
