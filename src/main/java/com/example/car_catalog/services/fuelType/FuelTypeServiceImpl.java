package com.example.car_catalog.services.fuelType;


import com.example.car_catalog.domain.entities.FuelType;
import com.example.car_catalog.repositories.FuelTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class FuelTypeServiceImpl implements FuelTypeService {

    private final FuelTypeRepository fuelTypeRepository;

    @Autowired
    public FuelTypeServiceImpl(FuelTypeRepository fuelTypeRepository) {
        this.fuelTypeRepository = fuelTypeRepository;
    }

    @Override
    public FuelType createFuelType(FuelType fuelType) {
        return fuelTypeRepository.save(fuelType);
    }

    @Override
    public FuelType updateFuelType(Long id, FuelType updatedFuelType) {
        FuelType existingFuelType = fuelTypeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("FuelType not found with id: " + id));
        existingFuelType.setName(updatedFuelType.getName());

        return fuelTypeRepository.save(existingFuelType);
    }

    @Override
    public void deleteFuelType(Long id) {
        FuelType fuelType = fuelTypeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("FuelType not found with id: " + id));

        fuelTypeRepository.delete(fuelType);
    }

    @Override
    public FuelType getFuelTypeById(Long id) {
        return fuelTypeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("FuelType not found with id: " + id));
    }

    @Override
    public List<FuelType> getAllFuelTypes() {
        return fuelTypeRepository.findAll();
    }
}