package MultiThreadingAndConcurency;



import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Thread.sleep;

public class Multithreading {

    public static void main(String args[]) throws InterruptedException {
        int noOfThreads = 13;

        /** First way of how to create a thread */

        System.out.println("These are thread class extended threads");
        for (int i = 0; i< noOfThreads; i++){
            multiThreadingDemo_extendingThreadClass mt = new multiThreadingDemo_extendingThreadClass();
            mt.start();
            System.out.println("TT");
        }

        /** Second way of  creating a thread */

        System.out.println("\nThese are thread class are created by runnable interface");
        multiThreadingDemo_implementingRunnableInterface mi = new multiThreadingDemo_implementingRunnableInterface();
        for (int i = 0; i< noOfThreads; i++){
            Thread thread = new Thread(mi);
            thread.start();
            System.out.println("TI");
        }
         /** We can also use lambda expression as Runnable is a functional interface */

         Thread thread1 = new Thread(()->{
            System.out.println("Thread by lambda " +  Thread.currentThread().getId() + " name " +
                    Thread.currentThread().getName() + "is running");//Thread logic
        });
        thread1.start();
    }
}
class multiThreadingDemo_extendingThreadClass extends Thread{

    public void run(){
        try{

            System.out.println("Thread " +  Thread.currentThread().getId() + " name " +
                    Thread.currentThread().getName() + "is running");
            sleep(1000);

        }catch(Exception exception){
            System.out.println("Exception is caught " +exception);
        }
    }

}
class multiThreadingDemo_implementingRunnableInterface implements Runnable{

    @Override
    public void run() {
        try{
            System.out.println("Thread " +  Thread.currentThread().getId() + " name " +
                    Thread.currentThread().getName() + "is running");
            sleep(1000);

        }catch(Exception exception){
            System.out.println("Exception is caught " +exception);
        }
    }

}

                 /*        Some important methods                        */

/*
1.isAlive();
2.
*/



                 /**        Methods to control thread execution          */

/**
static Methods to control thread execution

1.yield() - It suggest the jvm that the current thread is willing to yield(give up temporary) its current use
of the cpu.this allow other thread to run.But its highly depends and vary as per os and jvm implementation.

2.join() - It allows one thread to wait for the completion of another thread.When a thread calls 'join' on another thread.
the calling thread will wait until the other thread has finished executing.It is often used for coordination between the threads.

3.sleep() - It causes current thread execution to sleep temporarily for a specified number of millisecond.
*/

class ThreadExecutionMethods{
    public static void main(String args[]) throws InterruptedException {
        Thread th1 = new Thread(()->{
            System.out.println("Thread one  started");
        });
        th1.start();

        Thread th2 = new Thread(()->{
            try {
                Thread.sleep(1000);      // sleep method
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Thread.yield();                   // yield method may give chance
            System.out.println("Thread two started");
        });
        th2.start();
        th2.join();                          // join method here will make other wait un till th2 finish


        Thread th3 = new Thread(()->{
            System.out.println("Thread three started");
        });
        th3.start();

        try {
            th2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("main thread");
    }
}

/**

static Methods to control thread execution

1.wait() - method is used to make a thread wait until another thread notifies it..

2.notify() - method is used to wake up a single waiting thread.

3.notifyAll() - method is used to wake up all waiting threads.





                   Explanation of code given below
1.MessageBuffer is a simple class representing a buffer with a message, It has methods 'produce' and to add a message
and 'consume' to retrieve and process a message

2.'produce' and 'consumer' are threads that use the shared 'MessageBuffer' object.The producer produces message and the
consumer consume them.

3.In the 'produce' and 'consume' methods 'synchronized' is used to ensure that only one thread can access the shared
resources at a time.

4.The 'while' loops in the 'produce' and 'consume' methods are there to handle scenario of spurious wake ups. The thread
wait until the necessary condition is satisfied.
*/
class Main{
    public static void main(String args[]){
        MessageBuffer buffer = new MessageBuffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}

class MessageBuffer{
    private String message;
    private boolean hasMessage = false;

    synchronized void produce(String message) {
        while (hasMessage) {
            try {
                // Wait until the consumer consumes the message
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.message = message;
        hasMessage = true;
        // Notify the consumer that a message is ready
        notify();
    }

    synchronized String consume() {
        while (!hasMessage) {
            try {
                // Wait until the produces a message
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        //Get and reset the message
        String consumeMessage = message;
        hasMessage = false;
        // Notify the producer that the message has been consumed
        notify();
        return consumeMessage;
    }
}


class Producer extends Thread{
    private MessageBuffer buffer;
    public Producer(MessageBuffer buffer){
        this.buffer = buffer;
    }
    public void run(){
        for (int i = 1; i <=5 ; i++){
            String message = "Message" + i;
            buffer.produce(message);
            System.out.println("produced " + message);

        }
    }
}

class Consumer extends Thread{
    private MessageBuffer buffer;
    public Consumer(MessageBuffer buffer){
        this.buffer=buffer;
    }
    public void run(){
        for(int i =1; i<=5; i++){
            String consumedMessage = buffer.consume();
            System.out.println("Consumer:" + consumedMessage);
        }
    }
}


/** Concept of synchronization

Method Synchronization: Ensures that only one thread can execute a synchronized method of an object at a time.

Block Synchronization: Allows synchronization of specific sections of code within a method, using the synchronized
keyword with an object reference or class literal inside a block of code.

Static Synchronization: Synchronizes static methods or static blocks, ensuring that only one thread can execute a static
synchronized method or block at a time for the entire class.

* */


 class MessageProcessor {
     private static Queue<String> messages = new LinkedList<>();

    /** Method synchronization */
    public synchronized void addMessageSyncMethod(String message)
    {
        messages.add(message);
    }

    /** Block synchronization */
    public void addMessageSyncBlock(String message) {
        synchronized (this) {
            messages.add(message);
        }
    }

    /** Static method synchronization */
    public static synchronized void addStaticMessageSyncMethod(String message) {
        // Shared queue for all instances
        messages.add(message);
    }

    public void processMessages() {
        while (!messages.isEmpty()) {
            String message = messages.poll();
            System.out.println(Thread.currentThread().getName() + " - Processing message: " + message);
        }
    }
}

 class aboveTest {
    public static void main(String[] args) throws InterruptedException {
        MessageProcessor processor = new MessageProcessor();

        /** Method synchronization */
        Thread t1 = new Thread(() -> {
            processor.addMessageSyncMethod("Message A");
            processor.addMessageSyncMethod("Message B");
            processor.addMessageSyncMethod("Message C");
            processor.processMessages();
        });

        /** Block synchronization */
        Thread t2 = new Thread(() -> {
            processor.addMessageSyncBlock("Message 1");
            processor.addMessageSyncBlock("Message 2");
            processor.addMessageSyncBlock("Message 3");
            processor.processMessages();
        });

        /** Static method synchronization */
        Thread t3 = new Thread(() -> {
            MessageProcessor.addStaticMessageSyncMethod("Message X");
            MessageProcessor.addStaticMessageSyncMethod("Message Y");
            MessageProcessor.addStaticMessageSyncMethod("Message Z");
            processor.processMessages();
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}

/**
* Expected Output Differences
Method Synchronization: Messages A, B, C will be processed together, then messages 1, 2, 3, and finally messages X, Y, Z.
Block Synchronization: Messages A, B, C, 1, 2, 3, X, Y, Z may be interleaved depending on thread scheduling.
Static Method Synchronization: All messages X, Y, Z will be processed together, followed by A, B, C and then 1, 2, 3.
The output order will vary due to differences in synchronization, demonstrating how the choice of synchronization can affect the order of execution in a multi-threaded environment.

outputs

Method Synchronization (addMessageSyncMethod):
Thread-0 - Processing message: Message A
Thread-0 - Processing message: Message B
Thread-0 - Processing message: Message C

Block Synchronization (addMessageSyncBlock):

Thread-1 - Processing message: Message 1
Thread-1 - Processing message: Message 2
Thread-1 - Processing message: Message 3

Static Method Synchronization (addStaticMessageSyncMethod):
Thread-2 - Processing message: Message X
Thread-2 - Processing message: Message Y
Thread-2 - Processing message: Message Z


*/
