package Important_concepts_to_revice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
* Following are the points to be taken care of
1.Try to use less static object and variables
 Static objects and variables are stored in the PermGen (Permanent Generation) or Metaspace memory area in Java, depending on
 the version. These memory areas have fixed sizes and are not garbage collected like the heap memory. Therefore, using fewer
 static objects and variables can help conserve memory usage, especially in long-running applications where static objects
 persist for the entire lifetime of the application.

 2.Release object after use every time by making them null
 Generally incorrect. In Java, setting a reference to null does not immediately free the memory occupied by the object.
 The memory is only reclaimed by the garbage collector when there are no more references to the object (i.e., when the object
 becomes unreachable). Manually setting references to null after using objects is usually unnecessary and can even be
 counterproductive. Modern garbage collectors are efficient at reclaiming memory, and explicit nulling of references can
 sometimes interfere with the garbage collector's optimization strategies. It's better to rely on the garbage collector to
 manage memory automatically. However, there are exceptions, such as releasing resources associated with objects (e.g., closing
 files or database connections), where explicit cleanup may be necessary. In such cases, it's recommended to use
 try-with-resources blocks or implement the AutoCloseable interface for automatic resource management.


3.Use try with resources with auto closable
 * */



public class GarbageCollection {
    public static GarbageCollection static_garbageCollection = new GarbageCollection();


    public static void main(String[] args) throws IOException {

//  collection framework object
        List<String> list = new ArrayList<>();
        list.add("hello");
        list = null; // Remove reference to the list

//  Array object
        int[] array = new int[10];
        array[3] = 7;
        array = null; // Release the memory occupied by the array

//  Object or static object
        GarbageCollection garbageCollection = new GarbageCollection();
        // using object
        static_garbageCollection = null; // Release the memory occupied by the object
        garbageCollection = null;


//  Using try with resources, try(resources){}catch(){}
        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {

            // Use the BufferedReader and BufferedWriter
            System.out.println("using buffer reader");
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
           //The BufferedReader will be automatically closed at the end of the try block, whether an exception occurs or not.

        } catch (IOException e) {
            // Handle exception
        }
//  Using finally with tryCatch
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("output.txt");
            GarbageCollection gc = new GarbageCollection();

        } catch (Exception e) {
            //Handling exception
        } finally {
            fos.close();
        }
    }
}


/**
 What are AutoCloseable interfaces and give examples:

 The AutoCloseable interface in Java is implemented by classes whose instances can be automatically closed when used
 with try-with-resources. Any class that implements AutoCloseable must provide a close() method that releases any resources
 held by the object. Some examples of classes that implement AutoCloseable are InputStream, OutputStream, Reader, Writer,
 Socket, ServerSocket, Connection (in JDBC), etc.



Spaces in Garbage Collection in Java:

 Young Generation: This is the area where new objects are allocated and promoted from. It is divided into three spaces:

 Eden Space: This is where new objects are initially allocated.
 Survivor Space 1 (S1): After a minor GC, surviving objects are moved from Eden to S1.
 Survivor Space 2 (S2): In the next minor GC, surviving objects from S1 are moved to S2.


 Old Generation (Tenured/Permanent Generation): This is the area where long-lived objects reside after being promoted from the Young Generation.


 Best Practices to Reduce Garbage and Save Memory:

 Avoid Unnecessary Object Creation: Create objects only when necessary and reuse existing objects whenever possible.
 Use Object Pooling: For frequently created objects, consider using object pooling to reduce the overhead of object creation and garbage collection.
 Prefer Immutable Objects: Immutable objects, once created, cannot be modified, which can help reduce the number of objects created and the need for garbage collection.
 Avoid Finalizers: Finalizers can cause performance issues and increase the cost of garbage collection. Use them only when necessary.
 Monitor and Tune Garbage Collection: Monitor the performance of garbage collection and tune the JVM settings based on your application's memory usage patterns.


 Dangerous Things Involving Memory:

 Memory Leaks: Unintentionally retaining references to objects that are no longer needed can lead to memory leaks, which can cause out-of-memory errors and performance issues.
 Excessive Temporary Object Creation: Creating and discarding large numbers of temporary objects can put pressure on the garbage collector and degrade performance.
 Inefficient Data Structures: Using inefficient data structures or misusing them can lead to excessive memory usage and unnecessary garbage collection overhead.
 Holding Onto Large Objects: Retaining references to large objects, such as large arrays or collections, can prevent them from being garbage collected and lead to memory issues.


 Writing Optimized Code:

 Understand Memory Management: Develop a deep understanding of Java's memory management, including the generational heap, garbage collection algorithms, and how objects are allocated and promoted.
 Profile and Analyze: Use profiling tools to identify memory hotspots and analyze object allocation patterns in your application.
 Implement Caching Strategies: Implement appropriate caching strategies to reduce the need for object creation and improve performance.
 Leverage Heap Monitoring Tools: Use tools like VisualVM or JConsole to monitor heap usage, identify memory leaks, and tune garbage collection settings.
 Follow Best Practices: Adhere to best practices for memory management, such as using memory-efficient data structures, avoiding unnecessary object creation, and properly managing object lifecycles.
 Continual Optimization: Continuously monitor and optimize your code for memory usage and garbage collection performance, especially as your application evolves or scales.



 Remember, garbage collection is a complex topic, and its performance depends on various factors, including the application's memory usage patterns, the JVM settings, and the
 underlying hardware. It's essential to understand the trade-offs between performance and memory usage and to strike the right balance for your specific use case.
 * */