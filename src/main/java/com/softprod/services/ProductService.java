package com.softprod.services;

import com.softprod.entities.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> readProducts();

    Product updateProduct(Product product);

    Product deleteProduct(Long productId);
}