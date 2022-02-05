package com.abramovvicz.kafkaWorkExample;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.abramovvicz.kafkaWorkExample.AppConst.TOPIC_NAME;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

//    private final KafkaProcessor kafkaProcessor;
//
//    @KafkaListener(topics = TOPIC_NAME)
//    void consumer(ConsumerRecord<String, String> ex) {
//        log.info("Consuming message: { }", ex.value());
//        try {
//            kafkaProcessor.process(ex.value());
//        } catch (Exception e) {
//            log.error("some error");
//        }
//    }
}
