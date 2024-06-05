package JAVA8.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**

Key Points about Parallel JAVA8.MessagesQueues.Streams
1.Easy Conversion
You can convert a sequential stream to a parallel stream by invoking the 'parallel()' method on the screen

2.Parallel Execution
Operations on a parallel stream are performed concurrently on multiple threads, potentially utilizing the
available cores on your machine

3.Performance Considerations
Parallel streams are beneficial for computational intensive tasks where the workload can be divided among multiple
processor

4.Thread safety
When you are using parallel streams, ensure that the operations performed on the element are thread safe.

 */
public class ParallelStreams {
public static void main(String args[]){

    List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    long parallelSum = numbers.parallelStream()
            .mapToLong(Integer::longValue)
            .sum();
    System.out.println(parallelSum);

    /** You can see as we had not used mapToLong we are not able to use sum()*/
    Optional<Long> first = numbers.parallelStream().map(Integer::longValue).findFirst();
    Long aLong = numbers.parallelStream().map(Integer::longValue).findFirst().orElse(0L);
    System.out.println(first + " and " + aLong);


}

}


