package com.softprod.market.controllers;

import com.softprod.market.dto.requests.ProductDtoRequest;
import com.softprod.market.dto.responses.ProductDtoResponse;
import com.softprod.market.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.softprod.market.utils.Constants.*;
import static com.softprod.market.utils.Constants.PRODUCTS;
import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
@RequestMapping(API_URL)
public class ProductController {

    private final ProductService productService;

    @ResponseStatus(CREATED)
    @PostMapping(PRODUCT_URL)
    public ProductDtoResponse createProduct(@RequestBody ProductDtoRequest request) {
        return productService.createProduct(request);
    }

    @GetMapping(PRODUCT_ID_URL)
    public ProductDtoResponse findProduct(@PathVariable UUID id) {
        return productService.findProduct(id);
    }

    @GetMapping(PRODUCTS)
    public List<ProductDtoResponse> findAllProducts() {
        return productService.findAllProducts();
    }

    @PutMapping(PRODUCT_ID_URL)
    public ProductDtoResponse updateProduct(@RequestBody ProductDtoRequest request, @PathVariable UUID id) {
        return productService.updateProduct(request, id);
    }

    @DeleteMapping(PRODUCT_ID_URL)
    public void deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
    }
}