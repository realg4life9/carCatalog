package com.example.car_catalog.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Car extends BaseEntity {
    @Column(name = "vin_number")
    private String vinNumber;
    @ManyToOne
   // @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "model_id")
    private Model model;
    @Column
    private BigDecimal price;
    @Column(name = "reg_date")
    private LocalDate regDate;
    @ManyToOne
    //@Fetch(FetchMode.JOIN)
    @JoinColumn(name = "transmission_id")
    private Transmission transmission;
    @ManyToOne
   //@Fetch(FetchMode.JOIN)
    @JoinColumn(name = "fuel_type_id")
    private FuelType fuelType;
    @Column
    private String remarks;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + getId() +
                ", vinNumber='" + getVinNumber() + '\'' +
                ", price=" + getPrice() +
                ", regDate=" + getRegDate() +
                ", remarks='" + getRemarks() + '\'' +
                ", fuelType=" + (fuelType != null ? fuelType.getName() : "null") +
                ", model=" + (model != null ? model.getName() : "null") +
                ", brand=" + (model != null && model.getBrand() != null ? model.getBrand().getName() : "null") +
                '}';
    }
}


