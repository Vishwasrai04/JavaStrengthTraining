package MessageQueues.SimpleMessage;

import java.util.LinkedList;
import java.util.Queue;

public class simplemessage {

    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer(producer);

        // Producing messages
        producer.produceMessage("Hello");
        producer.produceMessage("How are you?");
        producer.produceMessage("Goodbye");

        // Consuming messages
        consumer.consumeMessage();
        consumer.consumeMessage();
        consumer.consumeMessage();
        consumer.consumeMessage(); // Trying to consume when no messages left
    }

}


// Message class to hold the content of messages
class Message {
    private String content;

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

// Producer class to generate messages and enqueue them
class Producer {
    private Queue<Message> messageQueue;

    public Producer() {
        messageQueue = new LinkedList<>();
    }

    public void produceMessage(String content) {
        Message message = new Message(content);
        messageQueue.offer(message);
        System.out.println("Produced message: " + content);
    }

    public Message getMessage() {
        return messageQueue.poll();
    }
}

// Consumer class to consume messages from the queue
class Consumer {
    private Producer producer;

    public Consumer(Producer producer) {
        this.producer = producer;
    }

    public void consumeMessage() {
        Message message = producer.getMessage();
        if (message != null) {
            System.out.println("Consumed message: " + message.getContent());
        } else {
            System.out.println("No messages to consume.");
        }
    }
}


