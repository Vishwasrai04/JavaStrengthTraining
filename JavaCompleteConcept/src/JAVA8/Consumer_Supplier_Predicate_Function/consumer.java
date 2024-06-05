package JAVA8.Consumer_Supplier_Predicate_Function;

import java.util.function.Consumer;

public class consumer {

    public static void main(String args[]){
        Consumer<Integer> consumer = new Consumer<>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer * 12);
            }
        };
        consumer.accept(12);
        getmet(12,consumer);


        /** With help of lambda expression */

         Consumer  consum = (i) -> {
            System.out.println(i);
        };
        consum.accept("hi");


        getmet(12, (s)->{
            System.out.println(s);
        });

        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());
        Consumer<String> printLength = s -> System.out.println("Length: " + s.length());

        // Chain the Consumer operations using andThen method
        /** addThen method of consumer */
        Consumer<String> printUpperCaseAndLength = printUpperCase.andThen(printLength);
        printUpperCaseAndLength.accept("Happy");


    }
    public static void getmet(int x, Consumer<Integer> cons){
        cons.accept(x);
    }


}
