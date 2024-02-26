package com.softprod.store.services;

import com.softprod.store.dto.requests.CustomerDtoRequest;
import com.softprod.store.dto.responses.CustomerDtoResponse;
import com.softprod.store.entities.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    CustomerDtoResponse createCustomer(CustomerDtoRequest request);

    List<CustomerDtoResponse> findAllCustomers();

    Customer findCustomer(UUID id);

    CustomerDtoResponse updateCustomer(CustomerDtoRequest request, UUID id);

    void deleteCustomer(UUID id);

    void addProductToCustomerBasket(UUID productId, UUID customerId);

    void removeProductFromCustomerBasket(UUID productId, UUID customerId);
}