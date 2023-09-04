package com.example.car_catalog.services.car;

import com.example.car_catalog.domain.dtos.CarSearchCriteriaDTO;
import com.example.car_catalog.domain.entities.Car;
import com.example.car_catalog.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    @Transactional
    public Car createCar(Car car) {
        /*validateMandatoryFields(car);*/
        return carRepository.save(car);
    }

    @Override
    @Transactional
    public Car updateCar(Car updatedCar) {
        Car existingCar = carRepository.findById(updatedCar.getId())
                .orElseThrow(() -> new NoSuchElementException("Car not found with id: " + updatedCar.getId()));
        existingCar.setPrice(updatedCar.getPrice());
        existingCar.setRegDate(updatedCar.getRegDate());
        existingCar.setRemarks(updatedCar.getRemarks());
        existingCar.setVinNumber(updatedCar.getVinNumber());
        existingCar.setFuelType(updatedCar.getFuelType());
        existingCar.setModel(updatedCar.getModel());
        existingCar.getModel().setBrand(updatedCar.getModel().getBrand());
        existingCar.setTransmission(updatedCar.getTransmission());

        return carRepository.save(existingCar);
    }

    @Override
    @Transactional
    public Car deleteCar(Long carId) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new NoSuchElementException("Car not found with id: " + carId));

        carRepository.delete(car);
        return car;
    }

    public List<Car> searchCars(CarSearchCriteriaDTO searchCriteria) {
        return carRepository.searchCars(searchCriteria.getPriceMin(), searchCriteria.getPriceMax(), searchCriteria.getModelId(), searchCriteria.getBrandId(),
                searchCriteria.getFuelTypeId(), searchCriteria.getRegDateMin(), searchCriteria.getRegDateMax(), searchCriteria.getTransmissionId());
    }

    @Override
    public Car getCarById(Long carId) {
        return carRepository.findById(carId)
                .orElseThrow(() -> new NoSuchElementException("Car not found with id: " + carId));
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

   /* private void validateMandatoryFields(Car car) {
        if (car.getId() == null) {
            throw new IllegalArgumentException("Id is mandatory");
        }

        if (car.getPrice() == null) {
            throw new IllegalArgumentException("Price is mandatory");
        }

        if (car.getRemarks() == null) {
            throw new IllegalArgumentException("Remarks is mandatory");
        }

        if (car.getVinNumber() == null) {
            throw new IllegalArgumentException("VIN number is mandatory");
        }

        if (car.getFuelType() == null) {
            throw new IllegalArgumentException("Fuel type is mandatory");
        }

        if (car.getModel() == null) {
            throw new IllegalArgumentException("Model is mandatory");
        }

        if (car.getModel().getBrand() == null) {
            throw new IllegalArgumentException("Brand is mandatory");
        }

        if (car.getTransmission() == null) {
            throw new IllegalArgumentException("Transmission type is mandatory");
        }
    }

    */
}