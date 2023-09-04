package com.example.car_catalog.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Model extends BaseEntity {
    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
