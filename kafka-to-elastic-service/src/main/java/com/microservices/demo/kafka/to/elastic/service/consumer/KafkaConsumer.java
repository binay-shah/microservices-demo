package com.microservices.demo.kafka.to.elastic.service.consumer;

import java.util.List;

import org.apache.avro.specific.SpecificRecordBase;

public interface KafkaConsumer<T extends SpecificRecordBase> {
    void receive(List<T> messages, List<Integer> keys, List<Integer> partitions, List<Long> offset);
}
