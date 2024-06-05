package JAVA8.Streams;

import java.util.List;
import java.util.stream.Stream;

public class MethodReference {

    public static void main(String args[]){

        MethodReference mt = new MethodReference();
/** Here we can see that static method called with class name  JAVA8.MessagesQueues.MethodReference::staticPrint */
/** Here we can see that static method called with instance name   JAVA8.MessagesQueues.MethodReference::staticPrint*/
        Stream.iterate(1, val->val).limit(10).forEach(MethodReference::staticPrint);
        Stream.iterate(2,val->val*val).limit(5).forEach(mt::instancePrint);

        /**Some other example*/
        String[] strings = List.of("apple", "orange", "mango").stream().toArray(String[]::new); /**listStream.toArray(value -> new String[value])*/
        List.of("apple", "orange", "mango").stream().forEach(System.out::println);


    }

    public static void staticPrint(int x){
        System.out.println("printed this number inside static method=" + x);
    }
    public void instancePrint(int x){
        System.out.println("Printed this number inside instance method=" + x);
    }
}
