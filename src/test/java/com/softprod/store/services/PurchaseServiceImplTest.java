package com.softprod.store.services;

import com.softprod.store.dto.responses.PurchaseDtoResponse;
import com.softprod.store.entities.Purchase;
import com.softprod.store.mappers.PurchaseMapper;
import com.softprod.store.mappers.PurchaseMapperImpl;
import com.softprod.store.repositories.PurchaseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static com.softprod.store.enums.PurchaseStatus.COMPLETE;
import static com.softprod.store.enums.PurchaseStatus.IN_PROCESS;
import static java.util.UUID.fromString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PurchaseServiceImplTest {

    @Mock
    private PurchaseRepository purchaseRepository;

    @Spy
    private PurchaseMapper purchaseMapper = new PurchaseMapperImpl();

    @InjectMocks
    private PurchaseServiceImpl purchaseService;

    @Test
    public void testFindAllPurchases() {
        when(purchaseRepository.findAll()).thenReturn(getPreparedPurchases());
        List<PurchaseDtoResponse> purchases = purchaseService.findAllPurchases();
        assertEquals(getPreparedPurchasesDto(), purchases);
    }

    private List<Purchase> getPreparedPurchases() {
        Purchase purchase1 = Purchase.builder()
                .id(fromString("7f3dbd67-405a-476a-bda9-38d77b82e83c"))
                .totalPrice(new BigDecimal("2000"))
                .productsCount(7)
                .status(IN_PROCESS)
                .build();
        Purchase purchase2 = Purchase.builder()
                .id(fromString("ec4c00d6-7871-4641-93fc-4bc1cf753cd5"))
                .totalPrice(new BigDecimal("3321.89"))
                .productsCount(11)
                .status(COMPLETE)
                .build();
        return List.of(purchase1, purchase2);
    }

    private List<PurchaseDtoResponse> getPreparedPurchasesDto() {
        List<Purchase> purchases = getPreparedPurchases();
        Purchase purchase1 = purchases.get(0);
        Purchase purchase2 = purchases.get(1);
        PurchaseDtoResponse purchaseDtoResponse1 = PurchaseDtoResponse.builder()
                .id(purchase1.getId())
                .totalPrice(purchase1.getTotalPrice())
                .productsCount(purchase1.getProductsCount())
                .status(purchase1.getStatus())
                .build();
        PurchaseDtoResponse purchaseDtoResponse2 = PurchaseDtoResponse.builder()
                .id(purchase2.getId())
                .totalPrice(purchase2.getTotalPrice())
                .productsCount(purchase2.getProductsCount())
                .status(purchase2.getStatus())
                .build();
        return List.of(purchaseDtoResponse1, purchaseDtoResponse2);
    }
}