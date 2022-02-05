package com.abramovvicz.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
record CustomerService(CustomerRepository customerRepository) {
    void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                                    .firstName(request.firstName())
                                    .lastName(request.lastName())
                                    .email(request.email())
                                    .build();
        //todo: validation email, if email is taken, store customer in db
        log.info("Saving customer: {}", customer);
        customerRepository.save(customer);
    }

    List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
}
