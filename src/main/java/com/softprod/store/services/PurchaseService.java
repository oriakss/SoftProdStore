package com.softprod.store.services;

import com.softprod.store.dto.requests.PurchaseDtoRequest;
import com.softprod.store.dto.responses.PurchaseDtoResponse;

import java.util.List;
import java.util.UUID;

public interface PurchaseService {

    PurchaseDtoResponse createPurchase(UUID userId);

    List<PurchaseDtoResponse> findAllPurchases();

    PurchaseDtoResponse findPurchase(UUID id);

    PurchaseDtoResponse updatePurchase(PurchaseDtoRequest request, UUID id);

    void deletePurchase(UUID id);
}