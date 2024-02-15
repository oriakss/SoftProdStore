package com.softprod.market.services;

import com.softprod.market.dto.requests.PurchaseDtoRequest;
import com.softprod.market.dto.responses.PurchaseDtoResponse;
import com.softprod.market.entities.Purchase;
import com.softprod.market.entities.Customer;
import com.softprod.market.exceptions.PurchaseNotFoundException;
import com.softprod.market.mappers.PurchaseMapper;
import com.softprod.market.repositories.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseMapper purchaseMapper;
    private final PurchaseRepository purchaseRepository;
    private final CustomerService customerService;

    @Override
    @Transactional
    public PurchaseDtoResponse createPurchase(UUID customerId) {
        Customer customer = customerService.findCustomer(customerId);
        Purchase purchase = purchaseMapper.buildPurchase(customer);
        purchaseRepository.save(purchase);
        customer.getBasket().clear();
        customer.getPurchases().add(purchase);
        customerService.updateCustomer(customer);
        return purchaseMapper.convertPurchaseToPurchaseDtoResponse(purchase);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseDtoResponse> findAllPurchases() {
        return purchaseRepository
                .findAll()
                .stream()
                .map(purchaseMapper::convertPurchaseToPurchaseDtoResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public PurchaseDtoResponse findPurchase(UUID id) {
        return purchaseMapper.convertPurchaseToPurchaseDtoResponse(purchaseRepository.findById(id)
                .orElseThrow(() -> new PurchaseNotFoundException(id.toString())));
    }

    @Override
    @Transactional
    public PurchaseDtoResponse updatePurchase(PurchaseDtoRequest request, UUID id) {
        Purchase purchase = purchaseMapper.convertPurchaseDtoRequestToPurchase(request);
        purchase.setId(id);
        purchaseRepository.save(purchase);
        return purchaseMapper.convertPurchaseToPurchaseDtoResponse(purchase);
    }

    @Override
    @Transactional
    public void deletePurchase(UUID id) {
        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(() -> new PurchaseNotFoundException(id.toString()));
        Customer customer = purchase.getCustomer();
        if (customer != null) {
            customer.getPurchases().remove(purchase);
            customerService.updateCustomer(customer);
        }
        purchaseRepository.deleteById(id);
    }
}