package com.betrybe.products.services;

import com.betrybe.products.entities.Category;
import com.betrybe.products.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  public Category insertCategory(Category category) {
    return categoryRepository.save(category);
  }

  public Optional<Category> updateCategory(Long id, Category category) {

    Optional<Category> optionalCategory = categoryRepository.findById(id);

    if(optionalCategory.isPresent()) {
      Category categoryFromDB = optionalCategory.get();
      categoryFromDB.setName(category.getName());

      Category updatedCategory = categoryRepository.save(categoryFromDB);
      return Optional.of(updatedCategory);

    }

    return optionalCategory;
  }

  public Optional<Category> removeCategoryById(Long id) {

    Optional<Category> categoryOptional = categoryRepository.findById(id);

    if(categoryOptional.isPresent()) {
      categoryRepository.deleteById(id);
    }

    return categoryOptional;
  }

  public Optional<Category> getCategoryById(Long id) {
    return categoryRepository.findById(id);
  }

  public List<Category> getAllCategories() {
    return categoryRepository.findAll();
  }
}