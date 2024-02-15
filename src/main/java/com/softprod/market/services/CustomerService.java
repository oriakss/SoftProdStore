package com.softprod.market.services;

import com.softprod.market.dto.requests.CustomerDtoRequest;
import com.softprod.market.dto.responses.CustomerDtoResponse;
import com.softprod.market.entities.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    CustomerDtoResponse createCustomer(CustomerDtoRequest request);

    List<CustomerDtoResponse> findAllCustomers();

    Customer findCustomer(UUID id);

    CustomerDtoResponse updateCustomer(CustomerDtoRequest request, UUID id);

    void updateCustomer(Customer customer);

    void deleteCustomer(UUID id);

    void addProductToCustomerBasket(UUID productId, UUID customerId);

    void removeProductFromCustomerBasket(UUID productId, UUID customerId);
}