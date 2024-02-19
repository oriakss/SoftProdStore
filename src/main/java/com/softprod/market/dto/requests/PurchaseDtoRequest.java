package com.softprod.market.dto.requests;

import com.softprod.market.enums.PurchaseStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PurchaseDtoRequest {

    @NotNull(message = "Purchase total price can't be null")
    private BigDecimal totalPrice;

    @NotNull(message = "Purchase product's num can't be null")
    private Integer productsNum;

    @NotNull(message = "Purchase status can't be null")
    private PurchaseStatus status;
}