package com.softprod.repositories;

import com.softprod.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> createProduct(Product product);

    Optional<List<Product>> readProducts();

    Optional<Product> updateProduct(Product product);

    Optional<Product> deleteProduct(Product product);
}
