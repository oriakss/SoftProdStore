package com.softprod.services;

import com.softprod.entities.Product;
import com.softprod.repositories.ProductRepository;
import com.softprod.repositories.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private static ProductService productService;
    private final ProductRepository productRepository = ProductRepositoryImpl.getInstance();

    @Override
    public void createProduct(Product product) {
        productRepository.createProduct(product).orElseThrow();
    }

    @Override
    public List<Product> readProducts() {
        return productRepository.readProducts().orElseThrow();
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.updateProduct(product).orElseThrow();
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteProduct(productId).orElseThrow();
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