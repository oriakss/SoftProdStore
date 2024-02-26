package com.softprod.store.entities;

import com.softprod.store.enums.ProductCategory;
import com.softprod.store.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static com.softprod.store.utils.Constants.*;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.AUTO;

@Data
@ToString(exclude = {"customers", "purchases"})
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = PRODUCT)
public class Product {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = ID_COLUMN)
    private UUID id;

    @Column(name = NAME_COLUMN, nullable = false)
    private String name;

    @Column(name = BRAND_COLUMN, nullable = false)
    private String brand;

    @Enumerated(STRING)
    @Column(name = CATEGORY_COLUMN, nullable = false)
    private ProductCategory category;

    @Column(name = PRICE_COLUMN, nullable = false)
    private BigDecimal price;

    @Enumerated(STRING)
    @Column(name = STATUS_COLUMN, nullable = false)
    private ProductStatus status;

    @ManyToMany(mappedBy = BASKET)
    private List<Customer> customers;

    @ManyToMany(mappedBy = PRODUCTS)
    private List<Purchase> purchases;
}