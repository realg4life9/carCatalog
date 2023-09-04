package com.example.car_catalog.services.brands;


import com.example.car_catalog.domain.entities.Brand;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandService {
    Brand createBrand(Brand brand);

    Brand updateBrand(Long id, Brand updatedBrand);

    void deleteBrand(Long id);

    Brand getBrandById(Long id);

    List<Brand> getAllBrands();
}
