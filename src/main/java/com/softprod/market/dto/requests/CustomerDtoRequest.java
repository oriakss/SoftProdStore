package com.softprod.market.dto.requests;

import com.softprod.market.entities.CustomerRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDtoRequest {

    private String name;
    private String email;
    private String login;
    private String password;
    private CustomerRole customerRole;
}