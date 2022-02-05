package com.abramovvicz.fraud;

import com.abramovvicz.clients.fraud.FraudCheckResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check/")
@Slf4j
record FraudCheckController(FraudCheckHistoryService fraudCheckHistoryService) {

    @GetMapping(path = "{customerId}")
    FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        boolean isFraudulentCustomer = fraudCheckHistoryService.isFraudulentCustomer(customerId);
        log.info("check request is fraudster user:{}", customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }

}
