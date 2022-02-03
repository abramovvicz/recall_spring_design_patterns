package com.abramovvicz.kafkaWorkExample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
class EmbeddedKafkaIntegrationTest {


    @Autowired
    public KafkaTemplate<String, String> template;

    @Autowired
    private KafkaConsumerB consumer;

    @Autowired
    private KafkaProducer producer;

    @Value("${test.topic}")
    private String topic;


    @Test
    void dupa() {

    }

}