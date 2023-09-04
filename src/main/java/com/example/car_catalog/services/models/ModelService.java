package com.example.car_catalog.services.models;


import com.example.car_catalog.domain.entities.Model;

import java.util.List;

public interface ModelService {

    Model createModel(Model model);

    Model updateModel(Long id, Model updatedModel);

    void deleteModel(Long id);

    Model getModelById(Long id);

    List<Model> getAllModels();

    Model createModelWithBrand(String modelName, String brandName);
}
