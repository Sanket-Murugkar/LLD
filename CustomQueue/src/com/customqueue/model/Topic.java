package com.customqueue.model;

import java.util.List;

public class Topic {

    private String topicName;
    private String topicId;

    public String getTopicId() {
        return topicId;
    }

    public List<Message> getMessages() {
        return messages;
    }

    private List<Message> messages;

    public List<TopicSubscriber> getSubcribers() {
        return subcribers;
    }

    private List<TopicSubscriber> subcribers;

    public Topic(String topicName, String topicId) {
        this.topicName = topicName;
        this.topicId = topicId;
    }

    public void addSubscriber(TopicSubscriber topicSubscriber){
        this.subcribers.add(topicSubscriber);
    }

    public void addMessage(Message message){
        this.messages.add(message);
    }

    public String getTopicName() {
        return topicName;
    }
}
