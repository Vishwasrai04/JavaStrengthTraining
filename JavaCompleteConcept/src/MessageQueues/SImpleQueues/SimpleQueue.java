package MessageQueues.SImpleQueues;
import java.util.LinkedList;
import java.util.Queue;



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

// Publisher class to publish messages to the queue
class Publisher {
    private Queue<Message> messageQueue;

    public Publisher() {

        messageQueue = new LinkedList<>();
    }

    public void publishMessage(String content) {
        Message message = new Message(content);
        messageQueue.offer(message);
        System.out.println("Published message: " + content);
    }

    public Message getNextMessage() {
        return messageQueue.poll();
    }
}

// Subscriber class to consume messages from the queue
class Subscriber {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public void handleMessage(Message message) {
        System.out.println(name + " received message: " + message.getContent());
    }
}

public class SimpleQueue {

    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        Subscriber subscriber1 = new Subscriber("Subscriber 1");
        Subscriber subscriber2 = new Subscriber("Subscriber 2");

        // Publishing messages
        publisher.publishMessage("Hello, world!");
        publisher.publishMessage("How are you?");

        // Subscribing and consuming messages
        Message message1 = publisher.getNextMessage();
        if (message1 != null) {
            subscriber1.handleMessage(message1);
        }

        Message message2 = publisher.getNextMessage();
        if (message2 != null) {
            subscriber2.handleMessage(message2);
        }
    }

}
