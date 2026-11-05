package org.example.exception;

public class SubscriptionException extends RuntimeException {
    private final String subscriber;
    private final String operation;

    public SubscriptionException(String message, String subscriber, String operation) {
        super(message);
        this.subscriber = subscriber;
        this.operation = operation;
    }

    public String getSubscriber() { return subscriber; }
    public String getOperation() { return operation; }
}