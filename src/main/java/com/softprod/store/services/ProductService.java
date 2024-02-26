package com.softprod.store.services;

import com.softprod.store.dto.requests.ProductDtoRequest;
import com.softprod.store.dto.responses.ProductDtoResponse;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    ProductDtoResponse createProduct(ProductDtoRequest request);

    List<ProductDtoResponse> findAllProducts();

    ProductDtoResponse findProduct(UUID id);

    ProductDtoResponse updateProduct(ProductDtoRequest request, UUID id);

    void deleteProduct(UUID id);
}