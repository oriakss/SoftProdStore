package com.softprod.store.services;

import com.softprod.store.dto.responses.CustomerDtoResponse;
import com.softprod.store.entities.Customer;
import com.softprod.store.mappers.CustomerMapper;
import com.softprod.store.mappers.CustomerMapperImpl;
import com.softprod.store.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.softprod.store.enums.CustomerRole.*;
import static java.util.UUID.fromString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @Spy
    private CustomerMapper customerMapper = new CustomerMapperImpl();

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    public void testFindAllCustomers() {
        when(customerRepository.findAll()).thenReturn(getPreparedCustomers());
        List<CustomerDtoResponse> customersDto = customerService.findAllCustomers();
        assertEquals(getPreparedCustomersDto(), customersDto);
    }

    private List<Customer> getPreparedCustomers() {
        Customer customer1 = Customer.builder()
                .id(fromString("f3d1dc32-9e04-4d53-adbc-85f0e8b8fdbc"))
                .name("Yulia")
                .email("yulia@email.com")
                .login("yulia")
                .password("yulia")
                .customerRole(ADMIN)
                .build();
        Customer customer2 = Customer.builder()
                .id(fromString("ad25225f-dd2d-45a8-8de1-065d64c4eb8d"))
                .name("Mark")
                .email("mark@email.com")
                .login("mark")
                .password("mark")
                .customerRole(CUSTOMER)
                .build();
        return List.of(customer1, customer2);
    }

    private List<CustomerDtoResponse> getPreparedCustomersDto() {
        List<Customer> customers = getPreparedCustomers();
        Customer customer1 = customers.get(0);
        Customer customer2 = customers.get(1);
        CustomerDtoResponse customerDtoResponse1 = CustomerDtoResponse.builder()
                .id(customer1.getId())
                .name(customer1.getName())
                .email(customer1.getEmail())
                .login(customer1.getLogin())
                .customerRole(customer1.getCustomerRole())
                .build();
        CustomerDtoResponse customerDtoResponse2 = CustomerDtoResponse.builder()
                .id(customer2.getId())
                .name(customer2.getName())
                .email(customer2.getEmail())
                .login(customer2.getLogin())
                .customerRole(customer2.getCustomerRole())
                .build();
        return List.of(customerDtoResponse1, customerDtoResponse2);
    }
}