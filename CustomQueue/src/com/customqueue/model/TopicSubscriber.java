package com.customqueue.model;

import com.customqueue.subscriber.ISubscriber;

import java.util.concurrent.atomic.AtomicInteger;

public class TopicSubscriber {

    private AtomicInteger offSet;
    private final ISubscriber subscriber;

    public TopicSubscriber(ISubscriber subscriber) {
        this.subscriber = subscriber;
    }

    public AtomicInteger getOffSet() {
        return offSet;
    }

    public ISubscriber getSubscriber() {
        return subscriber;
    }
}
