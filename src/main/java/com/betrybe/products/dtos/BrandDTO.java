package com.betrybe.products.dtos;

import com.betrybe.products.entities.Brand;

public record BrandDTO(Long id, String name) {

  public Brand toBrand() {
    return new Brand(id, name);
  }
}