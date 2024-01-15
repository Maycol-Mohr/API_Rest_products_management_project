package com.betrybe.products.services;

import com.betrybe.products.entities.Brand;
import com.betrybe.products.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

  @Autowired
  private BrandRepository brandRepository;

  public Brand insertBrand(Brand brand) {
    return brandRepository.save(brand);
  }

  public Optional<Brand> updateBrand(Long id, Brand brand) {

    Optional<Brand> optionalBrand = brandRepository.findById(id);

    if(optionalBrand.isPresent()) {
      Brand brandFromDB = optionalBrand.get();
      brandFromDB.setName(brand.getName());

      Brand updatedBrand = brandRepository.save(brandFromDB);
      return Optional.of(updatedBrand);

    }

    return optionalBrand;
  }

  public Optional<Brand> removeBrandById(Long id) {

    Optional<Brand> brandOptional = brandRepository.findById(id);

    if(brandOptional.isPresent()) {
      brandRepository.deleteById(id);
    }

    return brandOptional;
  }

  public Optional<Brand> getBrandById(Long id) {
    return brandRepository.findById(id);
  }

  public List<Brand> getAllBrands() {
    return brandRepository.findAll();
  }
}