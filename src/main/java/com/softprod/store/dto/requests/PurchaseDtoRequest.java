package com.softprod.store.dto.requests;

import com.softprod.store.enums.PurchaseStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PurchaseDtoRequest {

    @NotNull(message = "Purchase total price can't be null")
    private BigDecimal totalPrice;

    @NotNull(message = "Purchase products count can't be null")
    private Integer productsCount;

    @NotNull(message = "Purchase status can't be null")
    private PurchaseStatus status;
}