package com.softprod.store.mappers;

import com.softprod.store.dto.requests.CustomerDtoRequest;
import com.softprod.store.dto.responses.CustomerDtoResponse;
import com.softprod.store.entities.Customer;
import org.mapstruct.*;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
public interface CustomerMapper {

    Customer convertCustomerDtoRequestToCustomer(CustomerDtoRequest request);

    CustomerDtoResponse convertCustomerToCustomerDtoResponse(Customer customer);
}