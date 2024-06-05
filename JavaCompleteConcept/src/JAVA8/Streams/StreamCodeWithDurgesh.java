package JAVA8.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCodeWithDurgesh {

    public static void main(String args[]){

        // Create a list and filter even numbers
        List<Integer> x = List.of(1,3,4,5,7);
        List<Integer> y = Arrays.asList(2,3,9,8);


        x =  x.stream().filter(val->val%2==0).collect(Collectors.toList());
        System.out.println(x);

        Stream<Integer>st =Stream.empty();
        st.forEach(val-> System.out.println(val));

        y = y.stream().map(ele -> ele*ele).collect(Collectors.toList());
        System.out.println(y);
        // fileter(condition true the pass element further)
        // map perform operation on each element
        // sorted()

        y = y.stream().sorted().collect(Collectors.toList());
        System.out.println(y);


        Integer integer = y.stream().min((a,b) -> a.compareTo(b)).get();


    }
}
