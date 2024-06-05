package JAVA8.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleStreamExample {
public static void main(String args[]){

    //Stream for collections
    List<String> myList = List.of("apple","orange","mango");
    Stream<String>listStream = myList.stream();

    // Stream for arrays
    String[] arr = {"milk","curd","butter_milk"};
    Stream<String>stream1 = Arrays.stream(arr);

    // Directly using Stream.of()
    Stream<String> streamOfNames = Stream.of("Alice", "Bob", "Charlie", "David");
    // Generate an infinite Stream
    Stream<Double> random = Stream.generate(() -> Math.random());

    // Intermediate Operations that transform stream into another stream.
    System.out.println(listStream.filter(s -> s.startsWith("a")).collect(Collectors.toList()));
    System.out.println(listStream.map(s -> s.toUpperCase()).collect(Collectors.toList()));
    listStream.distinct();
    listStream.sorted();
    // Note:- Very important point once any of the above four will work at a time otherwise error:stream has already been operated upon or closed

     // terminal Operations
     listStream.forEach(System.out::println);
     listStream.toArray(String[]::new);        //listStream.toArray(value -> new String[value])
     listStream.filter(name->name.startsWith("A"))
             .forEach(System.out::println);

     // Handling Optional
    Optional<String> firstNameWithC = listStream
            .filter(name->name.startsWith("c"))
            .findFirst();

}
}
