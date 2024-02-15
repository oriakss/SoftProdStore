package com.softprod.market.controllers;

import com.softprod.market.dto.requests.PurchaseDtoRequest;
import com.softprod.market.dto.responses.PurchaseDtoResponse;
import com.softprod.market.services.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.softprod.market.utils.Constants.*;
import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
@RequestMapping(API_URL)
public class PurchaseController {

    private final PurchaseService purchaseService;

    @ResponseStatus(CREATED)
    @PostMapping(PURCHASE_URL)
    public PurchaseDtoResponse createPurchase(@RequestBody UUID userId) {
        return purchaseService.createPurchase(userId);
    }

    @GetMapping(PURCHASE_ID_URL)
    public PurchaseDtoResponse findPurchase(@PathVariable UUID id) {
        return purchaseService.findPurchase(id);
    }

    @GetMapping(PURCHASES_URL)
    public List<PurchaseDtoResponse> findAllPurchases() {
        return purchaseService.findAllPurchases();
    }

    @PutMapping(PURCHASE_ID_URL)
    public PurchaseDtoResponse updatePurchase(@RequestBody PurchaseDtoRequest request, @PathVariable UUID id) {
        return purchaseService.updatePurchase(request, id);
    }

    @DeleteMapping(PURCHASE_ID_URL)
    public void deletePurchase(@PathVariable UUID id) {
        purchaseService.deletePurchase(id);
    }
}