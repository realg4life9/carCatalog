package com.example.car_catalog.domain.dtos;

import com.example.car_catalog.domain.entities.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarSearchCriteriaDTO {
    BigDecimal priceMin;
    BigDecimal priceMax;
    Long modelId;
    Long brandId;
    Long fuelTypeId;
    LocalDate regDateMin;
    LocalDate regDateMax;
    Long transmissionId;
}
