package JAVA8.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Few stream method i have used
 * 1.filter
 * 2.forEach
 * 3.sorted
 * 4.map
 * 5.flatMap
 * 6.reduce
 * 7.groupingBy
 * 8.Count
 * 9.collect
 * 10.Min
 * 11.max
 * */
public class BasicStreamFunctionPrograms {

    public static void main(String srgs[]){

        /*** reduce ***/
        List<Integer> numbers0 = Arrays.asList(4, 2, 7, 5, 9, 3);
        Optional<Integer> sum = numbers0.stream().reduce((x, y) -> x + y);
        System.out.println("Sum of numbers: " + sum.orElse(null));

        List<Integer> numbs = Arrays.asList(3, 7, 1, 9, 4);
        Optional<Integer> min = numbs.stream().reduce(Integer::min);
        System.out.println("Minimum: " + min.orElse(null));

        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
        int product = num.stream().reduce(1, (x, y) -> x * y);
        System.out.println("Product: " + product);

        /*** MAX ***/

        List<Integer> numbers = Arrays.asList(4, 2, 7, 5, 9, 3);
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        System.out.println("Maximum number: " + max.orElse(0));
        /**op = 9*/

        // same thing as above
        List<Integer> numbers2 = Arrays.asList(4, 2, 7, 5, 9, 3);
        Optional<Integer> max1 = numbers2.stream().max((x1, x2) -> x1.compareTo(x2));
        System.out.println(max1);
        /**op = 9*/

        List<Integer> number3 = Arrays.asList(4, 2, 7, 5, 9, 3);
        Optional<Integer> max3 = number3.stream().max((x1, x2) -> Integer.compare(x1,x2));
        /**op = 3*  Did you see the difference between x1.compare(x2) and Integer.compare(x1,x2)*/

        List<String> numb = Arrays.asList("hi","jk", "hgf","j");
        Optional<String> m = numb.stream().max(Comparator.comparing(x->x.length()));
        /**we can also use comparator inside max and min */


        /*** MIN ***/
        List<Integer> number4 = Arrays.asList(4, 2, 7, 5, 9, 3);
        number4.stream().min((integer, anotherInteger) -> integer.compareTo(anotherInteger));
        // same as max only difference is we are using min unction

        int min1 = Arrays.stream(new int[]{1, 2, 3, 4, 5})
                .min()
                .orElse(0);



        /*** filter ***/
        Stream<Integer> integerStream = Stream.of(1, 6, 7, 3, 4, 5 );
        List<Integer> collect = integerStream.filter(val -> val % 2 != 0).collect(Collectors.toList());


        /*** foreach ***/
        Stream.of(1,3,4,5,6,7).forEach(System.out::println);

        /** NOTE: java.lang.IllegalStateException: stream has already been operated upon or closed, typically occurs when you try to reuse a stream after it has been consumed or closed.*/

        /*** sorted ***/
        List<Integer>list = List.of(13,2,6,7,1,2);
        List<Integer> collect1 = list.stream().sorted().collect(Collectors.toList());
        System.out.println(collect1);

        List<Integer>list2 = List.of(13,2,6,7,1,2);
        Stream<Integer> sorted = list2.stream().sorted(Comparator.reverseOrder());
        System.out.println(sorted);

        List<String> strList = List.of("happy", "Ranu", "pari", "mummy");
        List<String> collect3 = strList.stream().sorted().collect(Collectors.toList());
        System.out.println(collect3);

        List<String> strList2 =List.of("happy", "Ranu", "pari", "mummy");
        List<String> collect2 = strList2.stream().sorted(Comparator.comparing(val -> val.length())).collect(Collectors.toList());
        System.out.println(collect2);
        
        /*** Count ***/
        List<String>list_of_students = List.of("rohit", "jay","shubham");
        long countStudent = list_of_students.stream().count();
        System.out.println("Total count of students : "+countStudent);

        /*** Sum ***/
        // if you have Array of long or int type then you can directly apply other wise you have to mapToInt, mapToLong

        Arrays.stream(new int[]{1,3,4,5}).sum();
        List.of(1,2,3,4,5).stream().mapToInt(val->val).sum();



    }
}
