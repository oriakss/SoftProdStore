package com.softprod.store.dto.responses;

import com.softprod.store.enums.PurchaseStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class PurchaseDtoResponse {

    private UUID id;
    private BigDecimal totalPrice;
    private int productsCount;
    private PurchaseStatus status;
}