package com.softprod.market.dto.requests;

import com.softprod.market.enums.CustomerRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDtoRequest {

    private String name;

    @Email
    @NotBlank(message = "Email can't be empty")
    private String email;

    @NotBlank(message = "Login can't be empty")
    private String login;

    @NotBlank(message = "Password can't be empty")
    private String password;

    @NotNull(message = "Customer role can't be null")
    private CustomerRole customerRole;
}