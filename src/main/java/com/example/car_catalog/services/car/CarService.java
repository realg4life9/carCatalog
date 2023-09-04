package com.example.car_catalog.services.car;
import com.example.car_catalog.domain.dtos.CarSearchCriteriaDTO;
import com.example.car_catalog.domain.entities.Car;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarService {

    Car createCar(Car car);

    Car updateCar(Car updatedCar);

    Car deleteCar(Long carId);

    Car getCarById(Long carId);

    List<Car> getAllCars();


    List<Car> searchCars(CarSearchCriteriaDTO criteria);
}