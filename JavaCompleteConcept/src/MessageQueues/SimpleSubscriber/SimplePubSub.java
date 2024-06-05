package MessageQueues.SimpleSubscriber;

import java.util.ArrayList;
import java.util.List;
public class SimplePubSub {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        Subscriber subscriber1 = new SimpleSubscriber("Subscriber 1");
        Subscriber subscriber2 = new SimpleSubscriber("Subscriber 2");

        // Adding subscribers
        publisher.addSubscriber(subscriber1);
        publisher.addSubscriber(subscriber2);

        // Publishing messages
        publisher.publishMessage("Hello, world!");
        publisher.publishMessage("How are you?");
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

// Subscriber interface with a method to handle messages
interface Subscriber {
    void handleMessage(Message message);
}

// Publisher class to generate messages and notify subscribers
class Publisher {
    private List<Subscriber> subscribers;

    public Publisher() {
        subscribers = new ArrayList<>();
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void publishMessage(String content) {
        Message message = new Message(content);
        System.out.println("Published message: " + content);
        notifySubscribers(message);
    }

    private void notifySubscribers(Message message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.handleMessage(message);
        }
    }
}

// Subscriber implementation that simply prints the received message
class SimpleSubscriber implements Subscriber {
    private String name;

    public SimpleSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void handleMessage(Message message) {
        System.out.println(name + " received message: " + message.getContent());
    }
}


