package Operformance_Optimization;

/** First we will add dependency in pom.xml or build.gradlew

<dependency>
    <groupId>org.openjdk.jmh</groupId>
    <artifactId>jmh-core</artifactId>
    <version>1.32</version>
</dependency>
<dependency>
    <groupId>org.openjdk.jmh</groupId>
    <artifactId>jmh-generator-annprocess</artifactId>
    <version>1.32</version>
    <scope>provided</scope>
</dependency>
 **/



/**
 * import org.openjdk.jmh.annotations.Benchmark;
 * import org.openjdk.jmh.annotations.BenchmarkMode;
 * import org.openjdk.jmh.annotations.Mode;
 * import org.openjdk.jmh.annotations.OutputTimeUnit;
 * import java.util.concurrent.TimeUnit;
 * */
public class Benchmarking {


//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testMethod() {
        int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            sum += i;
        }
    }
/**
 * In this example, the testMethod is annotated with @Benchmark, which tells JMH that this is a benchmark method.
 * The @BenchmarkMode(Mode.AverageTime) annotation specifies that we want to measure the average time taken by the
 * method. The @OutputTimeUnit(TimeUnit.MILLISECONDS) annotation specifies the time unit for the benchmark results.
 */

/** Run : "java -jar target/benchmarks.jar Benchmarking"
 *
 This will generate benchmark results that you can analyze to identify areas for performance improvement.

 As for which benchmarking tool to use, JMH is highly recommended for Java applications due to its ease of
 use, powerful features, and integration with the Java ecosystem. It provides accurate and reliable benchmarking
 results, making it a preferred choice for performance optimization in Java.*/

}
