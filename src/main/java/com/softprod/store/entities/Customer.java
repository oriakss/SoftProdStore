package com.softprod.store.entities;

import com.softprod.store.enums.CustomerRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

import static com.softprod.store.utils.Constants.*;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.AUTO;

@Data
@ToString(exclude = {"basket", "purchases"})
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = CUSTOMER)
public class Customer {

    @Id
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

    @ManyToMany
    @JoinTable(name = CUSTOMER_PRODUCT,
            joinColumns = {@JoinColumn(name = CUSTOMER_ID)},
            inverseJoinColumns = {@JoinColumn(name = PRODUCT_ID)})
    private List<Product> basket;

    @OneToMany(mappedBy = CUSTOMER_FIELD)
    private List<Purchase> purchases;
}