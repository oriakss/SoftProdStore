package com.softprod.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static com.softprod.utils.Constants.*;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.AUTO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = PERSON)
public class User {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = ID_COLUMN)
    private Long id;

    @Column(name = USER_FIRSTNAME_COLUMN)
    private String firstname;

    @Column(name = USER_SURNAME_COLUMN)
    private String surname;

    @Column(name = USER_EMAIL_COLUMN)
    private String email;

    @Column(name = USER_LOGIN_COLUMN)
    private String login;

    @Column(name = USER_PASSWORD_COLUMN)
    private String password;

    @Enumerated(STRING)
    @Column(name = USER_ROLE_COLUMN)
    private UserRole userRole;
}