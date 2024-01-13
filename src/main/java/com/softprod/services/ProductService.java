package com.softprod.services;

import com.softprod.entities.Product;

import java.util.List;

public interface ProductService {

    void createProduct(Product product);

    List<Product> readProducts();

    void updateProduct(Product product);

    void deleteProduct(Long productId);
}