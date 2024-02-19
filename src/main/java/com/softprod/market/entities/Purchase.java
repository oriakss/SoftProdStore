package com.softprod.market.entities;

import com.softprod.market.enums.PurchaseStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static com.softprod.market.utils.Constants.*;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.AUTO;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = PURCHASE)
public class Purchase {

    @Id
    @EqualsAndHashCode.Exclude
    @GeneratedValue(strategy = AUTO)
    @Column(name = ID_COLUMN)
    private UUID id;

    @Column(name = TOTAL_PRICE_COLUMN, nullable = false)
    private BigDecimal totalPrice;

    @Column(name = PRODUCTS_NUM_COLUMN, nullable = false)
    private Integer productsNum;

    @Enumerated(STRING)
    @Column(name = STATUS_COLUMN, nullable = false)
    private PurchaseStatus status;

    @ManyToOne
    @JoinColumn(name = CUSTOMER_ID, updatable = false)
    private Customer customer;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = PURCHASE_PRODUCT,
            joinColumns = {@JoinColumn(name = PURCHASE_ID)},
            inverseJoinColumns = {@JoinColumn(name = PRODUCT_ID)})
    private List<Product> products;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy
                ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Purchase purchase = (Purchase) o;
        return getId() != null && Objects.equals(getId(), purchase.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}