package com.example.car_catalog.services.models;


import com.example.car_catalog.domain.entities.Brand;
import com.example.car_catalog.domain.entities.Model;
import com.example.car_catalog.repositories.BrandRepository;
import com.example.car_catalog.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public Model createModel(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public Model updateModel(Long id, Model updatedModel) {
        Model existingModel = modelRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Model not found with id: " + id));
        existingModel.setName(updatedModel.getName());
        existingModel.setBrand(updatedModel.getBrand());


        return modelRepository.save(existingModel);
    }

    @Override
    public void deleteModel(Long id) {
        Model model = modelRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Model not found with id: " + id));

        modelRepository.delete(model);
    }

    @Override
    public Model getModelById(Long id) {
        return modelRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Model not found with id: " + id));
    }

    @Override
    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }


    @Override
    public Model createModelWithBrand(String modelName, String brandName) {
        Model model = new Model();
        model.setName(modelName);

        Brand brand = new Brand();
        brand.setName(brandName);
        brandRepository.save(brand);

        model.setBrand(brand);

        return modelRepository.save(model);
    }

}

