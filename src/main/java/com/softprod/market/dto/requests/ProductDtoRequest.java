package com.softprod.market.dto.requests;

import com.softprod.market.enums.ProductCategory;
import com.softprod.market.enums.ProductStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductDtoRequest {

    @NotBlank(message = "Product name can't be blank")
    private String name;

    @NotBlank(message = "Product brand can't be blank")
    private String brand;

    @NotNull(message = "Product category can't be null")
    private ProductCategory category;

    @NotNull(message = "Product price can't be null")
    private BigDecimal price;

    @NotNull(message = "Product status can't be null")
    private ProductStatus status;
}