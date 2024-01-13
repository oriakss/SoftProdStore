package com.softprod.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.softprod.entities.UserRole.NO_ROLE;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String firstname;
    private String surname;
    private String email;
    private String login;
    private String password;
    private UserRole userRole;
}
