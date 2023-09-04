package com.example.car_catalog.services.transmission;

import com.example.car_catalog.domain.entities.Transmission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransmissionService {
    Transmission createTransmission(Transmission transmission);

    Transmission updateTransmission(Long id, Transmission updatedTransmission);

    void deleteTransmission(Long id);

    Transmission getTransmissionById(Long id);

    List<Transmission> getAllTransmissions();
}
