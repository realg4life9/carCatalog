package com.example.car_catalog.domain.constants;

import java.nio.file.Path;

public enum Paths {
    ;
    public static final Path BRAND_JSON_PATH =
            Path.of("src","main","resources","dbContent","brands.json");

    public static final Path FUEL_TYPE_JSON_PATH =
            Path.of("src","main","resources","dbContent","fuelTypes.json");

    public static final Path MODEL_JSON_PATH =
            Path.of("src","main","resources","dbContent","models.json");

    public static final Path TRANSMISSION_JSON_PATH =
            Path.of("src","main","resources","dbContent","transmissions.json");

}

