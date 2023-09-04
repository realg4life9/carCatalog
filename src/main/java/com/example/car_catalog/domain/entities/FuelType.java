package com.example.car_catalog.domain.entities;

import com.example.car_catalog.domain.entities.enums.FuelTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "fuel_type")
public class FuelType extends BaseEntity {

   /* @Enumerated(EnumType.STRING)
    @Column(name = "fuel_type_enum", nullable = false)*/
    @Column
    private String name;


}


