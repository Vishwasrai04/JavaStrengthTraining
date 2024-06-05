package JAVA8.Consumer_Supplier_Predicate_Function;
import java.util.function.Function;

public class Functions {



public static void main(String args[]){

    Function<Integer, Integer> function = new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer integer) {
            return integer*2;
        }
    };

    System.out.println(function.apply(12));


    Function<Integer, Integer> function2 = val->val*7;
    System.out.println(function2.apply(3));

    System.out.println(function.compose(function2));


    /** andThen */
    Function<Integer, Integer> first = x -> x * 2;
    Function<Integer, Integer> second = x -> x + 1;

    Function<Integer, Integer> doubleAndAddOne = first.andThen(second);
    int result1 = doubleAndAddOne.apply(5); // result1 is 11 (5 * 2 + 1)
    System.out.println(result1);

    /**Note:- The Compose method the output of the second function becomes the input of the first function.*/


    /** identity */
    Function<String, String> identityFunction = Function.identity();

    String res = identityFunction.apply("Hello");
    System.out.println("Result: " + res); // Output: Result: Hello World



    /** Compose*/
    Function<Integer, Integer> first1 = x -> x * 2;
    Function<Integer, Integer> second1 = x -> x + 1;

    Function<Integer, Integer> addOneAndDouble = first1.compose(second1);
    int result2 = addOneAndDouble.apply(5); // result2 is 12 ((5 + 1) * 2)
    System.out.println(result2);
    /**Note:- The andThen method the output of the first function becomes the input of the second function.*/



}

}
