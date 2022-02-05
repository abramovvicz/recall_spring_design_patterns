package com.abramovvicz.customer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
class CustomerConfig {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
