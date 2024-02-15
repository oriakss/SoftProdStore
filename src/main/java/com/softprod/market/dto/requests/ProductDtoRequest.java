package com.softprod.market.dto.requests;

import com.softprod.market.entities.ProductCategory;
import com.softprod.market.entities.ProductStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductDtoRequest {

    private String name;
    private String brand;
    private ProductCategory category;
    private BigDecimal price;
    private ProductStatus status;
}