package com.example.car_catalog.domain.constants;

import com.example.car_catalog.domain.dtos.CarDTO;
import com.example.car_catalog.domain.entities.Car;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public enum Utils {
    ;

    public static final ModelMapper MODEL_MAPPER = new ModelMapper();
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void writeJsonIntoFile(List<?> object, Path filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath.toFile());
        GSON.toJson(object,fileWriter);
        fileWriter.flush();
        fileWriter.close();
    }

    public static void writeJsonIntoFile(Object object, Path filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath.toFile());
        GSON.toJson(object,fileWriter);
        fileWriter.flush();
        fileWriter.close();
    }
}

