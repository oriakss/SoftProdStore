package com.softprod.store.services;

import com.softprod.store.dto.requests.ProductDtoRequest;
import com.softprod.store.dto.responses.ProductDtoResponse;
import com.softprod.store.entities.Product;
import com.softprod.store.exceptions.ProductNotFoundException;
import com.softprod.store.mappers.ProductMapper;
import com.softprod.store.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public ProductDtoResponse createProduct(ProductDtoRequest request) {
        Product product = productMapper.convertProductDtoRequestToProduct(request);
        productRepository.save(product);
        return productMapper.convertProductToProductDtoResponse(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDtoResponse> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::convertProductToProductDtoResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDtoResponse findProduct(UUID id) {
        return productMapper.convertProductToProductDtoResponse(productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id.toString())));
    }

    @Override
    @Transactional
    public ProductDtoResponse updateProduct(ProductDtoRequest request, UUID id) {
        Product product = productMapper.convertProductDtoRequestToProduct(request);
        product.setId(id);
        productRepository.save(product);
        return productMapper.convertProductToProductDtoResponse(product);
    }

    @Override
    @Transactional
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }
}