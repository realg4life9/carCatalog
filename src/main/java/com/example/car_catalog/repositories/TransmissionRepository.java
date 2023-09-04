package com.example.car_catalog.repositories;

import com.example.car_catalog.domain.entities.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransmissionRepository extends JpaRepository<Transmission,Long> {
}
