package com.softprod.store.entities;

import com.softprod.store.enums.PurchaseStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static com.softprod.store.utils.Constants.*;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.AUTO;

@Data
@ToString(exclude = "products")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = PURCHASE)
public class Purchase {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = ID_COLUMN)
    private UUID id;

    @Column(name = TOTAL_PRICE_COLUMN, nullable = false)
    private BigDecimal totalPrice;

    @Column(name = PRODUCTS_COUNT_COLUMN, nullable = false)
    private Integer productsCount;

    @Enumerated(STRING)
    @Column(name = STATUS_COLUMN, nullable = false)
    private PurchaseStatus status;

    @ManyToOne
    @JoinColumn(name = CUSTOMER_ID, updatable = false)
    private Customer customer;

    @ManyToMany
    @JoinTable(name = PURCHASE_PRODUCT,
            joinColumns = {@JoinColumn(name = PURCHASE_ID)},
            inverseJoinColumns = {@JoinColumn(name = PRODUCT_ID)})
    private List<Product> products;
}