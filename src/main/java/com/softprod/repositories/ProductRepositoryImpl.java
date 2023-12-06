package com.softprod.repositories;

import com.softprod.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {

    private static ProductRepository productRepository;

    private final List<Product> products = new ArrayList<>();

    private ProductRepositoryImpl() {
        products.add(new Product(1L, "product1", "brand1", "category1", 500));
        products.add(new Product(2L, "product2", "brand2", "category2", 300));
        products.add(new Product(3L, "product3", "brand3", "category3", 700));
        products.add(new Product(4L, "product4", "brand4", "category4", 900));
        products.add(new Product(5L, "product5", "brand5", "category5", 600));
    }

    @Override
    public Optional<Product> createProduct(Product product) {
        if (products.isEmpty()) {
            product.setId(1);
        } else {
            product.setId(products.get(products.size() - 1).getId() + 1);
        }
        products.add(product);
        return Optional.of(product);
    }

    @Override
    public Optional<List<Product>> readProducts() {
        return Optional.of(products);
    }

    @Override
    public Optional<Product> updateProduct(Product product) {
        Product oldProduct = products.stream()
                .filter(item -> Objects.equals(item.getId(), product.getId()))
                .findAny().orElseThrow();
        int ind = products.indexOf(oldProduct);
        products.remove(oldProduct);
        products.add(ind, product);
        return Optional.of(oldProduct);
    }

    @Override
    public Optional<Product> deleteProduct(Product product) {
        Product delProduct = products.stream()
                .filter(item -> Objects.equals(item.getId(), product.getId()))
                .findAny().orElseThrow();
        products.remove(delProduct);
        return Optional.of(delProduct);
    }

    public static ProductRepository getInstance() {
        if (productRepository == null) {
            productRepository = new ProductRepositoryImpl();
        }
        return productRepository;
    }
}
