package com.example.car_catalog.services.brands;

import com.example.car_catalog.domain.entities.Brand;
import com.example.car_catalog.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand updateBrand(Long id, Brand updatedBrand) {
        Brand existingBrand = brandRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Brand not found with id: " + id));
        existingBrand.setName(updatedBrand.getName());


        return brandRepository.save(existingBrand);
    }

    @Override
    public void deleteBrand(Long id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Brand not found with id: " + id));

        brandRepository.delete(brand);
    }

    @Override
    public Brand getBrandById(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Brand not found with id: " + id));
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }
}
