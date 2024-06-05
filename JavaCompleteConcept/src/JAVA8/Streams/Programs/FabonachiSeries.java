package JAVA8.Streams.Programs;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FabonachiSeries {
    public static void main(String args[]){

        List<Integer> collect = Stream.iterate(new int[]{0, 1}, val -> new int[]{val[1], val[1] + val[0]}).map(val -> val[0]).limit(10).collect(Collectors.toList());
        System.out.println(collect);

        Stream<Integer> integerStream = Stream.iterate(new int[]{1, 2}, val -> new int[]{val[1], val[1] + val[0]}).map(val -> val[0]);
        List<Integer> collect1 = integerStream.limit(10).collect(Collectors.toList());


        /** just an another example of iterator*/
        Predicate<Integer> hasNext = n -> n <= 8;
        UnaryOperator<Integer> next = n -> n + 2;

        List<Integer> evenNumbers = Stream.iterate(0, hasNext, next).limit(15)
                .collect(Collectors.toList());
        System.out.println(evenNumbers);
    }
}
