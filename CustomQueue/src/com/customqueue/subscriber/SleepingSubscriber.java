package com.customqueue.subscriber;

import com.customqueue.model.Message;

public class SleepingSubscriber implements ISubscriber{

    private String id;
    private Integer sleepTime;

    public SleepingSubscriber(String id, Integer sleepTime) {
        this.id = id;
        this.sleepTime = sleepTime;
    }

    @Override
    public void consume(Message message) throws InterruptedException {
        System.out.println("Subscriber: " + id + " started consuming: " + message.getMessage());
        Thread.sleep(sleepTime);
        System.out.println("Subscriber: " + id + " done consuming: " + message.getMessage());
    }

    @Override
    public String getId() {
        return id;
    }
}
