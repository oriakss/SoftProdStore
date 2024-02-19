package com.softprod.market.entities;

import com.softprod.market.enums.ProductCategory;
import com.softprod.market.enums.ProductStatus;
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
@Table(name = PRODUCT)
public class Product {

    @Id
    @EqualsAndHashCode.Exclude
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

    @ToString.Exclude
    @ManyToMany(mappedBy = BASKET)
    private List<Customer> customers;

    @ToString.Exclude
    @ManyToMany(mappedBy = PRODUCTS)
    private List<Purchase> purchases;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy
                ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Product product = (Product) o;
        return getId() != null && Objects.equals(getId(), product.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}