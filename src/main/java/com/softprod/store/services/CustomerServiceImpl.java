package com.softprod.store.services;

import com.softprod.store.dto.requests.CustomerDtoRequest;
import com.softprod.store.dto.responses.CustomerDtoResponse;
import com.softprod.store.entities.Customer;
import com.softprod.store.entities.Product;
import com.softprod.store.exceptions.CustomerNotFoundException;
import com.softprod.store.exceptions.ProductNotFoundException;
import com.softprod.store.mappers.CustomerMapper;
import com.softprod.store.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public CustomerDtoResponse createCustomer(CustomerDtoRequest request) {
        Customer customer = customerMapper.convertCustomerDtoRequestToCustomer(request);
        customerRepository.save(customer);
        return customerMapper.convertCustomerToCustomerDtoResponse(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDtoResponse> findAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::convertCustomerToCustomerDtoResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Customer findCustomer(UUID id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id.toString()));
    }

    @Override
    @Transactional
    public CustomerDtoResponse updateCustomer(CustomerDtoRequest request, UUID id) {
        Customer customer = customerMapper.convertCustomerDtoRequestToCustomer(request);
        customer.setId(id);
        customerRepository.save(customer);
        return customerMapper.convertCustomerToCustomerDtoResponse(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void addProductToCustomerBasket(UUID productId, UUID customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId.toString()));
        Product product = new Product();
        product.setId(productId);
        customer.getBasket().add(product);
    }

    @Override
    @Transactional
    public void removeProductFromCustomerBasket(UUID productId, UUID customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId.toString()));
        List<Product> basket = customer.getBasket();
        Product productById = basket.stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(productId.toString()));
        basket.remove(productById);
    }
}