package com.example.paragonordersservice.Services;

import com.example.paragonordersservice.Entities.CarEntity;
import com.example.paragonordersservice.Mappers.CarToEntityMapper;
import com.example.paragonordersservice.Objects.Car;
import com.example.paragonordersservice.Repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultCarService implements CarService {
    private final CarRepository carRepository;
    private final CarToEntityMapper mapper;

    @Override
    public Car getCarById(Long id) {
        CarEntity carEntity = carRepository.findById(id).get();
        return mapper.carEntityToCar(carEntity);
    }

    @Override
    public List<Car> getAllCars() {
        Iterable<CarEntity> iterable = carRepository.findAll();

        ArrayList<Car> cars = new ArrayList<>();
        for (CarEntity carEntity : iterable)
            cars.add(mapper.carEntityToCar(carEntity));

        return cars;
    }

    @Override
    public void addCar(Car car) {
        CarEntity carEntity = mapper.carToCarEntity(car);
        carRepository.save(carEntity);
    }

    @Override
    public List<Car> findByName(String name) {
        Iterable<CarEntity> iterable = carRepository.findAllByNameContaining(name);
        ArrayList<Car> cars = new ArrayList<>();
        for (CarEntity carEntity : iterable)
            cars.add(mapper.carEntityToCar(carEntity));

        return cars;
    }
}
