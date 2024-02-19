package com.softprod.market.entities;

import com.softprod.market.enums.CustomerRole;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

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
@Table(name = CUSTOMER)
public class Customer {

    @Id
    @EqualsAndHashCode.Exclude
    @GeneratedValue(strategy = AUTO)
    @Column(name = ID_COLUMN)
    private UUID id;

    @Column(name = NAME_COLUMN)
    private String name;

    @Column(name = EMAIL_COLUMN, nullable = false, unique = true)
    private String email;

    @Column(name = LOGIN_COLUMN, nullable = false, unique = true)
    private String login;

    @Column(name = PASSWORD_COLUMN, nullable = false)
    private String password;

    @Enumerated(STRING)
    @Column(name = ROLE_COLUMN, nullable = false)
    private CustomerRole customerRole;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = CUSTOMER_PRODUCT,
            joinColumns = {@JoinColumn(name = CUSTOMER_ID)},
            inverseJoinColumns = {@JoinColumn(name = PRODUCT_ID)})
    private List<Product> basket;

    @ToString.Exclude
    @OneToMany(mappedBy = CUSTOMER_LOWER)
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
        Customer customer = (Customer) o;
        return getId() != null && Objects.equals(getId(), customer.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}