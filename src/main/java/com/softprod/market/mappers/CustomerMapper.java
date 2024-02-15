package com.softprod.market.mappers;

import com.softprod.market.dto.requests.CustomerDtoRequest;
import com.softprod.market.dto.responses.CustomerDtoResponse;
import com.softprod.market.entities.Customer;
import org.mapstruct.*;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE, componentModel = SPRING)
public interface CustomerMapper {

    Customer convertCustomerDtoRequestToCustomer(CustomerDtoRequest request);

    CustomerDtoResponse convertCustomerToCustomerDtoResponse(Customer customer);
}