package com.example.paragonordersservice.Services;

import com.example.paragonordersservice.Objects.Car;

import java.util.List;

public interface CarService {
    Car getCarById(Long id);
    List<Car> getAllCars();
    void addCar(Car car);
    List<Car> findByName(String name);
}
