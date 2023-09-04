package com.example.car_catalog.repositories;

import com.example.car_catalog.domain.entities.Car;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("SELECT c FROM Car c " +
            "WHERE (:priceMin IS NULL OR c.price >= :priceMin) " +
            "AND (:priceMax IS NULL OR c.price <= :priceMax) " +
            "AND (:modelId IS NULL OR c.model.id = :modelId) " +
            "AND (:brandId IS NULL OR c.model.brand.id = :brandId) " +
            "AND (:fuelTypeId IS NULL OR c.fuelType.id = :fuelTypeId) " +
            "AND (:regDateMin IS NULL OR c.regDate >= :regDateMin) " +
            "AND (:regDateMax IS NULL OR c.regDate <= :regDateMax) " +
            "AND (:transmissionId IS NULL OR c.transmission.id = :transmissionId) " +
            "ORDER BY c.price DESC")
    List<Car> searchCars(
            @Param("priceMin") BigDecimal priceMin,
            @Param("priceMax") BigDecimal priceMax,
            @Param("modelId") Long modelId,
            @Param("brandId") Long brandId,
            @Param("fuelTypeId") Long fuelTypeId,
            @Param("regDateMin") LocalDate regDateMin,
            @Param("regDateMax") LocalDate regDateMax,
            @Param("transmissionId") Long transmissionId
    );

}
