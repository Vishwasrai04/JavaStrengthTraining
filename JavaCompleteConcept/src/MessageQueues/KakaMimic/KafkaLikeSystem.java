package MessageQueues.KakaMimic;
import java.util.LinkedList;
import java.util.Queue;

/**Components
 1. Producer: Publishes messages to a topic.
 2.Consumer: Subscribes to a topic and processes messages.
 3.Broker: Manages topics and message queues.

 * */

class Broker {
    private final Queue<String> queue = new LinkedList<>();
    private final int capacity;

    public Broker(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void publish(String message) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(message);
        System.out.println("Published: " + message);
        notifyAll();
    }

    public synchronized String consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        String message = queue.poll();
        notifyAll();
        return message;
    }
}

class Producer implements Runnable {
    private final Broker broker;

    public Producer(Broker broker) {
        this.broker = broker;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                broker.publish("Message " + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final Broker broker;

    public Consumer(Broker broker) {
        this.broker = broker;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = broker.consume();
                System.out.println("Consumed: " + message);
                Thread.sleep(150);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class KafkaLikeSystem {
    public static void main(String[] args) {
        Broker broker = new Broker(5);

        Thread producerThread = new Thread(new Producer(broker));
        Thread consumerThread = new Thread(new Consumer(broker));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
