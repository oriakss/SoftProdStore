package com.softprod.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

import static com.softprod.utils.Constants.*;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = PRODUCT)
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = ID_COLUMN)
    private Long id;

    @Column(name = NAME_COLUMN)
    private String name;

    @Column(name = BRAND_COLUMN)
    private String brand;

    @Enumerated(STRING)
    @Column(name = CATEGORY_COLUMN)
    private ProductCategory category;

    @Column(name = PRICE_COLUMN)
    private BigDecimal price;
}