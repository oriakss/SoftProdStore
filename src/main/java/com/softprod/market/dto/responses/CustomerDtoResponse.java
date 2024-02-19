package com.softprod.market.dto.responses;

import com.softprod.market.enums.CustomerRole;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CustomerDtoResponse {

    private UUID id;
    private String name;
    private String email;
    private String login;
    private CustomerRole customerRole;
}