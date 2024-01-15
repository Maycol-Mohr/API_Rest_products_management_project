package com.betrybe.products.dtos;

import com.betrybe.products.entities.Category;

public record CategoryDTO(Long id, String name) {

  public Category toCategory() {
    return new Category(id, name);
  }
}