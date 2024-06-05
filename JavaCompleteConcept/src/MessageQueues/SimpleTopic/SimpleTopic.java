package MessageQueues.SimpleTopic;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



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

// Publisher class to publish messages to topics
class Publisher {
    private Map<String, Set<Subscriber>> topicSubscribersMap;

    public Publisher() {
        topicSubscribersMap = new HashMap<>();
    }

    public void subscribe(String topic, Subscriber subscriber) {
        topicSubscribersMap.computeIfAbsent(topic, k -> new HashSet<>()).add(subscriber);
    }

    public void unsubscribe(String topic, Subscriber subscriber) {
        if (topicSubscribersMap.containsKey(topic)) {
            topicSubscribersMap.get(topic).remove(subscriber);
        }
    }

    public void publishMessage(String topic, String content) {
        Message message = new Message(content);
        System.out.println("Published message on topic '" + topic + "': " + content);
        Set<Subscriber> subscribers = topicSubscribersMap.getOrDefault(topic, new HashSet<>());
        for (Subscriber subscriber : subscribers) {
            subscriber.handleMessage(message);
        }
    }
}

// Subscriber interface with a method to handle messages
interface Subscriber {
    void handleMessage(Message message);
}

// SimpleSubscriber implementation that prints received messages
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

public class SimpleTopic {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();

        // Create subscribers
        Subscriber subscriber1 = new SimpleSubscriber("Subscriber 1");
        Subscriber subscriber2 = new SimpleSubscriber("Subscriber 2");

        // Subscribe subscribers to different topics
        publisher.subscribe("Java", subscriber1);
        publisher.subscribe("Kubernetes", subscriber2);
        publisher.subscribe("Java", subscriber2);

        // Publish messages to topics
        publisher.publishMessage("Java", "Welcome to the world of Java!");
        publisher.publishMessage("Kubernetes", "Introduction to Kubernetes");
        publisher.publishMessage("Java", "Java 101: Getting Started");
    }
}

