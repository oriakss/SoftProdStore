package com.softprod.market.dto.requests;

import com.softprod.market.entities.PurchaseStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PurchaseDtoRequest {

    private BigDecimal totalPrice;
    private int productsNum;
    private PurchaseStatus status;
}