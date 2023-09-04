package com.example.car_catalog.services.fuelType;


import com.example.car_catalog.domain.entities.FuelType;
import com.example.car_catalog.domain.entities.enums.FuelTypeEnum;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuelTypeService {
    FuelType createFuelType(FuelType fuelType);
    FuelType updateFuelType(Long id, FuelType updatedFuelType);
    void deleteFuelType(Long id);
    FuelType getFuelTypeById(Long id);
    List<FuelType> getAllFuelTypes();

}

