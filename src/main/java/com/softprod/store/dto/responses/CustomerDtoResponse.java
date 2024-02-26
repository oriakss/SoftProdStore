package com.softprod.store.dto.responses;

import com.softprod.store.enums.CustomerRole;
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