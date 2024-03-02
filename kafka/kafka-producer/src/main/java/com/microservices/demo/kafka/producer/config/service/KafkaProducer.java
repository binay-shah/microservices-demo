package com.microservices.demo.kafka.producer.config.service;

import java.io.Serializable;

import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.stereotype.Service;

@Service
public interface KafkaProducer<K extends Serializable, V extends SpecificRecordBase> {

    void send(String topicName, K key, V message);
}
