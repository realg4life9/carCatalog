package com.example.car_catalog.repositories;

import com.example.car_catalog.domain.entities.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelTypeRepository extends JpaRepository<FuelType, Long> {
}
