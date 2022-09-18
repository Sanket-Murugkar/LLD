package com.customqueue.handler;

import com.customqueue.model.Message;
import com.customqueue.model.Topic;
import com.customqueue.model.TopicSubscriber;

public class SubscriberWorker implements Runnable{

    private Topic topic;
    private TopicSubscriber topicSubscriber;
    public SubscriberWorker( final Topic topic, final TopicSubscriber topicSubscriber) {
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }


    @Override
    public void run() {
        synchronized (topicSubscriber) {
            do {
                int curOffset = topicSubscriber.getOffSet().get();
                while (curOffset >= topic.getMessages().size()) {
                    try {
                        topicSubscriber.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Message message = topic.getMessages().get(curOffset);
                try {
                    topicSubscriber.getSubscriber().consume(message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                // We cannot just increment here since subscriber offset can be reset while it is consuming. So, after
                // consuming we need to increase only if it was previous one.
                topicSubscriber.getOffSet().compareAndSet(curOffset, curOffset + 1);
            } while (true);
        }
    }

    synchronized public void wakeUpIfNeeded() {
        synchronized (topicSubscriber) {
            topicSubscriber.notify();
        }
    }
}
