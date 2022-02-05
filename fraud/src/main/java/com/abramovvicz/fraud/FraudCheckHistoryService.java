package com.abramovvicz.fraud;


import org.springframework.stereotype.Service;

import static com.abramovvicz.fraud.FraudCheckHistory.*;
import static java.time.LocalDateTime.now;

@Service
record FraudCheckHistoryService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {
    boolean isFraudulentCustomer(Integer customerId) {
        fraudCheckHistoryRepository.save(builder()
                                                 .customerId(customerId)
                                                 .isFraudster(false)
                                                 .createdAt(now())
                                                 .build());
        return false;
    }

}
