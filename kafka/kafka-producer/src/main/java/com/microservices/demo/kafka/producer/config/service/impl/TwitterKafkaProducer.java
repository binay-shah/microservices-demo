package com.microservices.demo.kafka.producer.config.service.impl;

import java.util.concurrent.CompletableFuture;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.microservices.demo.kafka.avro.model.TwitterAvroModel;
import com.microservices.demo.kafka.producer.config.service.KafkaProducer;
@Service
public class TwitterKafkaProducer implements KafkaProducer<Long, TwitterAvroModel> {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaProducer.class);

    private final KafkaTemplate<Long, TwitterAvroModel> kafkaTemplate;

    public TwitterKafkaProducer(KafkaTemplate<Long, TwitterAvroModel> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(String topicName, Long key, TwitterAvroModel message) {
        LOG.info("Sending message='{}' to topic='{}'", message.toString(), topicName.toString());
        CompletableFuture<SendResult<Long, TwitterAvroModel>> kafkaResultFuture =  kafkaTemplate.send(topicName, key, message);
        kafkaResultFuture.whenComplete((result, ex) -> {
            if (ex == null){
                RecordMetadata metadata = result.getRecordMetadata();
                LOG.debug("Received new metadata. Topic: {}; Partition {}; Offset; Timestamp {}, at time {}",
                    metadata.topic(),
                    metadata.partition(),
                    metadata.offset(),
                    metadata.timestamp(),
                    System.nanoTime());
            }else{
                kafkaResultFuture.completeExceptionally(ex);
            }
        });
    }
}
