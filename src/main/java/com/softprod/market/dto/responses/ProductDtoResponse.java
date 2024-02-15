package com.softprod.market.dto.responses;

import com.softprod.market.entities.ProductCategory;
import com.softprod.market.entities.ProductStatus;
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