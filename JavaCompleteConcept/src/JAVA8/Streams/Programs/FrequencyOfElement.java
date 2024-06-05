package JAVA8.Streams.Programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/** write a program to fetch frequency of each stream using*/
public class FrequencyOfElement {
    public static void main(String atgs[]){
        List<String>list = new ArrayList<>();
        list.add("hi");
        list.add("hih");
        list.add("hi");
        list.add("hih");
        list.add("hik");
        list.add("hi");
        list.add("hil");

        Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));




    }
}
