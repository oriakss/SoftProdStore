package com.softprod.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

import static com.softprod.utils.Constants.*;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = BOOKING)
public class Order {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = ID_COLUMN)
    private Long id;

    @Column(name = UUID_COLUMN)
    private UUID uuid;

    @Column(name = TOTAL_PRICE_COLUMN)
    private BigDecimal totalPrice;

    @Column(name = PRODUCTS_NUM_COLUMN)
    private int productsNum;

    @Enumerated(STRING)
    @Column(name = STATUS_COLUMN)
    private OrderStatus status;
}