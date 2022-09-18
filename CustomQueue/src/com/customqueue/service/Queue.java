package com.customqueue.service;

import com.customqueue.handler.TopicHandler;
import com.customqueue.model.Message;
import com.customqueue.model.Topic;
import com.customqueue.model.TopicSubscriber;
import com.customqueue.subscriber.ISubscriber;


import java.util.Map;
import java.util.UUID;

public class Queue {

    private Map<String,TopicHandler> topicProcessors;

    public Topic createTopic(final String topicName) {
        final Topic topic = new Topic(topicName, UUID.randomUUID().toString());
        TopicHandler topicHandler = new TopicHandler(topic);
        topicProcessors.put(topic.getTopicId(), topicHandler);
        System.out.println("Created topic: " + topic.getTopicName());
        return topic;
    }

    public void subscribe( final ISubscriber subscriber,final Topic topic) {
        topic.addSubscriber(new TopicSubscriber(subscriber));
        System.out.println(subscriber.getId() + " subscribed to topic: " + topic.getTopicName());
    }

    public void publish( final Topic topic,  final Message message) {
        topic.addMessage(message);
        System.out.println(message.getMessage() + " published to topic: " + topic.getTopicName());
        new Thread(() -> topicProcessors.get(topic.getTopicId()).publish()).start();
    }

    public void resetOffset( final Topic topic,final ISubscriber subscriber,  final Integer newOffset) {
        for (TopicSubscriber topicSubscriber : topic.getSubcribers()) {
            if (topicSubscriber.getSubscriber().equals(subscriber)) {
                topicSubscriber.getOffSet().set(newOffset);
                System.out.println(topicSubscriber.getSubscriber().getId() + " offset reset to: " + newOffset);
                new Thread(() -> topicProcessors.get(topic.getTopicId()).startSubsriberWorker(topicSubscriber)).start();
                break;
            }
        }
    }
}
