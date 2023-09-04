package com.example.car_catalog.domain.controller;

import com.example.car_catalog.domain.dtos.CarSearchCriteriaDTO;
import com.example.car_catalog.domain.entities.Car;
import com.example.car_catalog.services.car.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/findCar/{id}")
    public Optional<Car> findCarById(@PathVariable long id) {
        return Optional.ofNullable(carService.getCarById(id));
    }

    @PutMapping(value = "/createCar")
    public Car createNewCar(@RequestBody Car newCar) {
        return this.carService.createCar(newCar);
    }

    @PostMapping(value = "/editCar")
    public Car editCar(@RequestBody Car edittedCar) {

       return this.carService.updateCar(edittedCar);

    }
    @PostMapping("/search")
    public List<Car> searchByParams(@RequestBody CarSearchCriteriaDTO criteria) {
        return this.carService.searchCars(criteria);
    }


    @DeleteMapping(value = "/removeCar/{id}")
    public Car deleteCar(@PathVariable Long id) {
        return  this.carService.deleteCar(id);
    }


}
