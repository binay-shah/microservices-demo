package com.microservices.demo.admin.exception;

public class KafkaClientException extends RuntimeException{
    public KafkaClientException() {
        super();
    }

    public KafkaClientException(String message) {
        super(message);
    }

    public KafkaClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
