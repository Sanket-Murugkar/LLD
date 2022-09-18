package com.customqueue.handler;

import com.customqueue.model.Topic;
import com.customqueue.model.TopicSubscriber;

import java.util.Map;

public class TopicHandler {

    private final Topic topic;
    private final Map<String, SubscriberWorker> subscriberWorkers;

    public TopicHandler(Topic topic) {
        this.topic = topic;
    }

    public void publish() {
        for (TopicSubscriber topicSubscriber:topic.getSubcribers()) {
            startSubsriberWorker(topicSubscriber);
        }
    }


    public void startSubsriberWorker( final TopicSubscriber topicSubscriber) {
        final String subscriberId = topicSubscriber.getSubscriber().getId();
        if (!subscriberWorkers.containsKey(subscriberId)) {
            final SubscriberWorker subscriberWorker = new SubscriberWorker(topic, topicSubscriber);
            subscriberWorkers.put(subscriberId, subscriberWorker);
            new Thread(subscriberWorker).start();
        }
        final SubscriberWorker subscriberWorker = subscriberWorkers.get(subscriberId);
        subscriberWorker.wakeUpIfNeeded();
    }
}
