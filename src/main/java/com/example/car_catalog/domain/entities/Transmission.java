package com.example.car_catalog.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Transmission extends BaseEntity {
    @Column
    private String name;
}

