package com.example.car_catalog.repositories;

import com.example.car_catalog.domain.entities.Brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {
}
