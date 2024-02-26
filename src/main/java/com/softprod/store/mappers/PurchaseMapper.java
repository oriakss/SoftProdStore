package com.softprod.store.mappers;

import com.softprod.store.dto.requests.PurchaseDtoRequest;
import com.softprod.store.dto.responses.PurchaseDtoResponse;
import com.softprod.store.entities.Purchase;
import com.softprod.store.entities.Product;
import com.softprod.store.entities.Customer;
import org.mapstruct.Mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.softprod.store.enums.PurchaseStatus.IN_PROCESS;
import static java.math.BigDecimal.ZERO;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
public interface PurchaseMapper {

    Purchase convertPurchaseDtoRequestToPurchase(PurchaseDtoRequest request);

    PurchaseDtoResponse convertPurchaseToPurchaseDtoResponse(Purchase purchase);

    default Purchase buildPurchase(Customer customer) {
        List<Product> basket = customer.getBasket();
        return Purchase.builder()
                .products(new ArrayList<>(basket))
                .productsCount(basket.size())
                .totalPrice(getTotalPrice(basket))
                .status(IN_PROCESS)
                .customer(customer)
                .build();
    }

    default BigDecimal getTotalPrice(List<Product> products) {
        return products.stream()
                .map(Product::getPrice)
                .reduce(ZERO, BigDecimal::add);
    }
}