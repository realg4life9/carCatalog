package com.example.car_catalog.repositories;


import com.example.car_catalog.domain.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ModelRepository extends JpaRepository<Model,Long> {

}
