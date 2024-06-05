package MultiThreadingAndConcurency;

/**
 * In Java, a ThreadGroup is a class that represents a group of threads. It provides a convenient way to manage multiple threads as a single unit. Here's a comprehensive explanation of ThreadGroup along with its important features:
 *
 * Concept of ThreadGroup:
 * Grouping Threads:
 * ThreadGroup allows threads to be organized into a hierarchical structure.
 * Threads can be added to a ThreadGroup at the time of their creation or later using the Thread class constructors or ThreadGroup methods.
 * Hierarchical Structure:
 * ThreadGroups can have parent-child relationships, forming a hierarchical structure.
 * Each ThreadGroup except the root ThreadGroup has a parent ThreadGroup.
 * Common Properties:
 * ThreadGroups share certain properties such as the name, maximum priority, and daemon status.
 * When a new thread is created within a ThreadGroup, it inherits these properties from its parent ThreadGroup.
 * Managing Threads:
 * ThreadGroup provides methods to enumerate the threads within the group, interrupt all threads in the group, and set the maximum priority of all threads in the group.
 * Exception Handling:
 * ThreadGroup allows you to set an uncaught exception handler that will be invoked when a thread within the group terminates due to an uncaught exception.
 * */
public class ThreadGroup extends java.lang.ThreadGroup {

    public ThreadGroup(String name) {
        super(name);
    }

    public static void main(String args[]){


        ThreadGroup group = new ThreadGroup("My thread");

        Thread t1 = new Thread(group, () -> {
            // Thread task
        });
        t1.start();

        Thread t2 = new Thread(group, () -> {
            // Thread task
        });
        t2.start();

// Get active thread count in the group
        int activeThreadCount = group.activeCount();

// Interrupt all threads in the group
        group.interrupt();

// Set max priority for all threads in the group
        group.setMaxPriority(Thread.MAX_PRIORITY);


    }

}


/** This method is present in update versions of java
 *
 *  Set uncaught exception handler for the group
 *         group.setUncaughtExceptionHandler((thread, throwable) -> {
 *             // Handle uncaught exception
 *         });
 *
 */

