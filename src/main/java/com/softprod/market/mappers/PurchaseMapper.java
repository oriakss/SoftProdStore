package com.softprod.market.mappers;

import com.softprod.market.dto.requests.PurchaseDtoRequest;
import com.softprod.market.dto.responses.PurchaseDtoResponse;
import com.softprod.market.entities.Purchase;
import com.softprod.market.entities.Product;
import com.softprod.market.entities.Customer;
import org.mapstruct.Mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.softprod.market.enums.PurchaseStatus.IN_PROCESS;
import static java.math.BigDecimal.ZERO;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE, componentModel = SPRING)
public interface PurchaseMapper {

    Purchase convertPurchaseDtoRequestToPurchase(PurchaseDtoRequest request);

    PurchaseDtoResponse convertPurchaseToPurchaseDtoResponse(Purchase purchase);

    default Purchase buildPurchase(Customer customer) {
        List<Product> basket = customer.getBasket();
        return Purchase.builder()
                .products(new ArrayList<>(basket))
                .productsNum(basket.size())
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