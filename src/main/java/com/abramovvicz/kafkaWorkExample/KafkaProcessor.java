package com.abramovvicz.kafkaWorkExample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class KafkaProcessor {


    void process(List<String> messages) {
        for (String message : messages) {
            process(message);

        }
    }

    void process(String message) {
        log.info("Process message {} ", message);

        if (message.equals("dupa")) {
            System.exit(0);
        }
    }
}
