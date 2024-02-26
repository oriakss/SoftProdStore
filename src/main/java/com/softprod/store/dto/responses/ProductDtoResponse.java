package com.softprod.store.dto.responses;

import com.softprod.store.enums.ProductCategory;
import com.softprod.store.enums.ProductStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class ProductDtoResponse {

    private UUID id;
    private String name;
    private String brand;
    private ProductCategory category;
    private BigDecimal price;
    private ProductStatus status;
}