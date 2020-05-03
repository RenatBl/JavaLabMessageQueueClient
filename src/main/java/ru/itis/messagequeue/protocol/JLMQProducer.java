package ru.itis.messagequeue.protocol;

public class JLMQProducer {

    private String subject;

    public JLMQProducer subscribe(String subject) {
        this.subject = subject;
        return this;
    }
}
