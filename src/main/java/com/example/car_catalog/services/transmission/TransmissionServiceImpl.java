package com.example.car_catalog.services.transmission;

import com.example.car_catalog.domain.entities.Transmission;
import com.example.car_catalog.repositories.TransmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class TransmissionServiceImpl implements TransmissionService {

    private final TransmissionRepository transmissionRepository;

    @Autowired
    public TransmissionServiceImpl(TransmissionRepository transmissionRepository) {
        this.transmissionRepository = transmissionRepository;
    }

    @Override
    public Transmission createTransmission(Transmission transmission) {
        return transmissionRepository.save(transmission);
    }

    @Override
    public Transmission updateTransmission(Long id, Transmission updatedTransmission) {
        Transmission existingTransmission = transmissionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Transmission not found with id: " + id));

        existingTransmission.setName(updatedTransmission.getName());


        return transmissionRepository.save(existingTransmission);
    }

    @Override
    public void deleteTransmission(Long id) {
        Transmission transmission = transmissionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Transmission not found with id: " + id));

        transmissionRepository.delete(transmission);
    }

    @Override
    public Transmission getTransmissionById(Long id) {
        return transmissionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Transmission not found with id: " + id));
    }

    @Override
    public List<Transmission> getAllTransmissions() {
        return transmissionRepository.findAll();
    }
}
