package com.betrybe.products.services;

import com.betrybe.products.repositories.ProductRepository;
import com.betrybe.products.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public Product insertProduct(Product product) {
    return productRepository.save(product);
  }

  public Optional<Product> updateProduct(Long id, Product product) {

    Optional<Product> optionalProduct = productRepository.findById(id);

    if(optionalProduct.isPresent()) {
      Product productFromDB = optionalProduct.get();
      productFromDB.setName(product.getName());
      productFromDB.setPrice(product.getPrice());

      Product updatedProduct = productRepository.save(productFromDB);
      return Optional.of(updatedProduct);

    }

    return optionalProduct;
  }

  public Optional<Product> removeProductById(Long id) {

    Optional<Product> productOptional = productRepository.findById(id);

    if(productOptional.isPresent()) {
      productRepository.deleteById(id);
    }

    return productOptional;
  }

  public Optional<Product> getProductById(Long id) {
    return productRepository.findById(id);
  }

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }
}