package com.example.car_catalog.services.seeds;

import com.example.car_catalog.domain.dtos.BrandImportDTO;
import com.example.car_catalog.domain.dtos.FuelTypeImportDTO;
import com.example.car_catalog.domain.dtos.ModelImportDTO;
import com.example.car_catalog.domain.dtos.TransmissionImportDTO;
import com.example.car_catalog.domain.entities.Brand;
import com.example.car_catalog.domain.entities.FuelType;
import com.example.car_catalog.domain.entities.Model;
import com.example.car_catalog.domain.entities.Transmission;
import com.example.car_catalog.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.car_catalog.domain.constants.Paths.*;
import static com.example.car_catalog.domain.constants.Utils.GSON;
import static com.example.car_catalog.domain.constants.Utils.MODEL_MAPPER;

@Service
public class SeedServiceImpl implements SeedService {

    private final CarRepository carRepository;
    private final BrandRepository brandRepository;
    private final FuelTypeRepository fuelTypeRepository;
    private final ModelRepository modelRepository;
    private final TransmissionRepository transmissionRepository;

    @Autowired
    public SeedServiceImpl(CarRepository carRepository, BrandRepository brandRepository, FuelTypeRepository fuelTypeRepository, ModelRepository modelRepository, TransmissionRepository transmissionRepository) {
        this.carRepository = carRepository;
        this.brandRepository = brandRepository;
        this.fuelTypeRepository = fuelTypeRepository;
        this.modelRepository = modelRepository;
        this.transmissionRepository = transmissionRepository;
    }

    @Override
    public void seedCars() {
    }

    @Override
    public void seedBrands() throws IOException {
        if (this.brandRepository.count() == 0) {
            final FileReader fileReader = new FileReader(BRAND_JSON_PATH.toFile());
            List<Brand> brands = Arrays.stream(GSON.fromJson(fileReader, BrandImportDTO[].class))
                    .map(brandDTO -> MODEL_MAPPER.map(brandDTO, Brand.class))
                    .collect(Collectors.toList());

            this.brandRepository.saveAllAndFlush(brands);
            fileReader.close();
        }
    }

    @Override
    public void seedFuelTypes() throws IOException {
        if (this.fuelTypeRepository.count() == 0) {
            final FileReader fileReader = new FileReader(FUEL_TYPE_JSON_PATH.toFile());
            List<FuelType> fuelTypes = Arrays.stream(GSON.fromJson(fileReader, FuelTypeImportDTO[].class))
                    .map(fuelTypeDTO -> MODEL_MAPPER.map(fuelTypeDTO, FuelType.class))
                    .collect(Collectors.toList());

            this.fuelTypeRepository.saveAllAndFlush(fuelTypes);
            fileReader.close();
        }
    }

    @Override
    public void seedModels() throws IOException {
        if (this.modelRepository.count() == 0) {
            final FileReader fileReader = new FileReader(MODEL_JSON_PATH.toFile());
            List<Model> models = Arrays.stream(GSON.fromJson(fileReader, ModelImportDTO[].class))
                    .map(modelDTO -> MODEL_MAPPER.map(modelDTO, Model.class))
                    .collect(Collectors.toList());

            this.modelRepository.saveAllAndFlush(models);
            fileReader.close();
        }
    }

    @Override
    public void seedTransmissions() throws IOException {
        if (this.transmissionRepository.count() == 0) {
            final FileReader fileReader = new FileReader(TRANSMISSION_JSON_PATH.toFile());
            List<Transmission> transmissions = Arrays.stream(GSON.fromJson(fileReader, TransmissionImportDTO[].class))
                    .map(transmissionDTO -> MODEL_MAPPER.map(transmissionDTO, Transmission.class))
                    .collect(Collectors.toList());

            this.transmissionRepository.saveAllAndFlush(transmissions);
            fileReader.close();
        }
    }
}
