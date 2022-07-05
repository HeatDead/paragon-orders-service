package com.example.paragonordersservice.Controllers;

import com.example.paragonordersservice.Mappers.CarToDtoMapper;
import com.example.paragonordersservice.Mappers.CarToEntityMapper;
import com.example.paragonordersservice.Objects.Car;
import com.example.paragonordersservice.Requests.CarRequest;
import com.example.paragonordersservice.Services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    private final CarToDtoMapper mapper;

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @GetMapping
    public List<Car> getAllCars(@RequestParam(required = false) String name) {
        if (name != null)
            return carService.findByName(name);

        return carService.getAllCars();
    }

    @PostMapping
    public void addBook(@RequestBody CarRequest request) {
        carService.addCar(mapper.AddCarRequestToCar(request));
    }
}
