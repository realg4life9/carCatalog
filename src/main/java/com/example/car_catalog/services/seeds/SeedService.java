package com.example.car_catalog.services.seeds;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface SeedService {
    void seedCars();
    void seedBrands() throws IOException;
    void seedFuelTypes() throws IOException;
    void seedModels() throws IOException;
    void seedTransmissions() throws IOException;

    default void seedAll() throws IOException {
        seedCars();
        seedBrands();
        seedFuelTypes();
        seedModels();
        seedTransmissions();
    }

}
