package com.softprod.market.controllers;

import com.softprod.market.dto.requests.CustomerDtoRequest;
import com.softprod.market.dto.responses.CustomerDtoResponse;
import com.softprod.market.mappers.CustomerMapper;
import com.softprod.market.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.softprod.market.utils.Constants.*;
import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
@RequestMapping(API_URL)
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @ResponseStatus(CREATED)
    @PostMapping(CUSTOMER_LOWER)
    public CustomerDtoResponse createCustomer(@RequestBody @Valid CustomerDtoRequest request) {
        return customerService.createCustomer(request);
    }

    @GetMapping(CUSTOMER_ID_URL)
    public CustomerDtoResponse findCustomer(@PathVariable UUID id) {
        return customerMapper.convertCustomerToCustomerDtoResponse(customerService.findCustomer(id));
    }

    @GetMapping(CUSTOMERS_URL)
    public List<CustomerDtoResponse> findAllCustomers() {
        return customerService.findAllCustomers();
    }

    @PutMapping(CUSTOMER_ID_URL)
    public CustomerDtoResponse updateCustomer(@RequestBody @Valid CustomerDtoRequest request, @PathVariable UUID id) {
        return customerService.updateCustomer(request, id);
    }

    @DeleteMapping(CUSTOMER_ID_URL)
    public void deleteCustomer(@PathVariable UUID id) {
        customerService.deleteCustomer(id);
    }

    @PatchMapping(ADD_PRODUCT_TO_BASKET_URL)
    public void addProductToCustomerBasket(@RequestBody UUID productId, @PathVariable(name = ID) UUID customerId) {
        customerService.addProductToCustomerBasket(productId, customerId);
    }

    @PatchMapping(REMOVE_PRODUCT_FROM_BASKET_URL)
    public void removeProductFromCustomerBasket(@RequestBody UUID productId, @PathVariable(name = ID) UUID customerId) {
        customerService.removeProductFromCustomerBasket(productId, customerId);
    }
}