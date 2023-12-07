package com.softprod.repositories;

import com.softprod.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.softprod.utils.Constants.DEFAULT_ID;
import static com.softprod.utils.Constants.ONE_STEP;

public class ProductRepositoryImpl implements ProductRepository {

    private static ProductRepository productRepository;
    private final List<Product> products = new ArrayList<>();

    @Override
    public Optional<Product> createProduct(Product product) {
        if (products.isEmpty()) {
            product.setId(DEFAULT_ID);
        } else {
            product.setId(products.get(products.size() - ONE_STEP).getId() + DEFAULT_ID);
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
    public Optional<Product> deleteProduct(Long productId) {
        Product product = products.stream()
                .filter(item -> Objects.equals(item.getId(), productId))
                .findAny().orElseThrow();
        products.remove(product);
        return Optional.of(product);
    }

    public static ProductRepository getInstance() {
        if (productRepository == null) {
            productRepository = new ProductRepositoryImpl();
        }
        return productRepository;
    }

    private ProductRepositoryImpl() {
        products.add(new Product(1L, "product1", "brand1", "category1", 500));
        products.add(new Product(2L, "product2", "brand2", "category2", 300));
        products.add(new Product(3L, "product3", "brand3", "category3", 700));
        products.add(new Product(4L, "product4", "brand4", "category4", 900));
        products.add(new Product(5L, "product5", "brand5", "category5", 600));
    }
}