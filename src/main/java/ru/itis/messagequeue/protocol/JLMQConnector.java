package ru.itis.messagequeue.protocol;

public class JLMQConnector {

    private int port;
    private JLMQProducer producer;
    private JLMQConsumer consumer;

    public  JLMQConnector port(int port) {
        this.port = port;
        return this;
    }

    public JLMQConnector connect() {
        return this;
    }

    public JLMQProducer producer() {
        this.producer = new JLMQProducer();
        return producer;
    }

    public JLMQConsumer consumer() {
        this.consumer = new JLMQConsumer();
        return consumer;
    }
}
