package com.softprod.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static com.softprod.utils.Constants.*;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = PERSON)
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = ID_COLUMN)
    private Long id;

    @Column(name = FIRSTNAME_COLUMN)
    private String firstname;

    @Column(name = SURNAME_COLUMN)
    private String surname;

    @Column(name = EMAIL_COLUMN)
    private String email;

    @Column(name = LOGIN_COLUMN)
    private String login;

    @Column(name = PASSWORD_COLUMN)
    private String password;

    @Enumerated(STRING)
    @Column(name = ROLE_COLUMN)
    private UserRole userRole;
}