package com.softprod.services;

import com.softprod.entities.Product;
import com.softprod.repositories.ProductRepository;
import com.softprod.repositories.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private static ProductService productService;
    private final ProductRepository productRepository = ProductRepositoryImpl.getInstance();

    @Override
    public Product createProduct(Product product) {
        return productRepository.createProduct(product).orElseThrow();
    }

    @Override
    public List<Product> readProducts() {
        return productRepository.readProducts().orElseThrow();
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.updateProduct(product).orElseThrow();
    }

    @Override
    public Product deleteProduct(Long productId) {
        return productRepository.deleteProduct(productId).orElseThrow();
    }

    public static ProductService getInstance() {
        if (productService == null) {
            productService = new ProductServiceImpl();
        }
        return productService;
    }

    private ProductServiceImpl() {
    }
}