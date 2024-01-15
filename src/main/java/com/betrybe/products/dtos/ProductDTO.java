package com.betrybe.products.dtos;

import com.betrybe.products.entities.Product;

public record ProductDTO(Long id, String name, Double price) {

  public Product toProduct() {
    return new Product(id, name, price);
  }
}