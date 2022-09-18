package com.customqueue.subscriber;

import com.customqueue.model.Message;

public interface ISubscriber {

    void consume(Message message) throws InterruptedException;

    String getId();
}
