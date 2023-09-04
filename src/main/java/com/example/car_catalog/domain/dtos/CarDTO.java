package com.example.car_catalog.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {
        private Long id;
        private String vinNumber;
        private Double price;
        private Date regDate;
        private String remarks;

        private ModelImportDTO model;
        private BrandImportDTO brand;
        private FuelTypeImportDTO fuelType;
        private TransmissionImportDTO transmission;


    }
