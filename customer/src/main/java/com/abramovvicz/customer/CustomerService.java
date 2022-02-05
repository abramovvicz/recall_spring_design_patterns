package com.abramovvicz.customer;

import com.abramovvicz.clients.fraud.FraudCheckResponse;
import com.abramovvicz.clients.fraud.FraudClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate, FraudClient fraudClient) {
    void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                                    .firstName(request.firstName())
                                    .lastName(request.lastName())
                                    .email(request.email())
                                    .build();
        //todo: validation email, if email is taken, store customer in db
        customerRepository.saveAndFlush(customer);
        log.info("Saving customer: {}", customer);

        FraudCheckResponse fraudster = fraudClient.isFraudster(customer.getId());

        if (fraudster.isFraudster()) {
            throw new IllegalStateException("fruadster u son of the bitch");
        }
    }

    List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
}
