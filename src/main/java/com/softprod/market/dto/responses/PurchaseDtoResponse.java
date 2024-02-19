package com.softprod.market.dto.responses;

import com.softprod.market.enums.PurchaseStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class PurchaseDtoResponse {

    private UUID id;
    private BigDecimal totalPrice;
    private int productsNum;
    private PurchaseStatus status;
}