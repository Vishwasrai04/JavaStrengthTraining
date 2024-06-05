package JAVA8.Consumer_Supplier_Predicate_Function;

import java.util.function.Predicate;

public class predicate {

    public static void main(String args[]){
        Predicate<String> integerPredicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };
        System.out.println(integerPredicate.test("13"));
        System.out.println(integerPredicate.test("12"));

        /** 1.test(T t) method*/
        Predicate<Integer> isPositive = num -> num > 0;
        System.out.println(isPositive.test(5)); // Output: true
        System.out.println(isPositive.test(-3)); // Output: false


        /** 2.and(Predicate<? super T> other) */
        Predicate<Integer> isEven = num -> num % 2 == 0;
        Predicate<Integer> isPositiveAndEven = isPositive.and(isEven);
        System.out.println(isPositiveAndEven.test(6)); // Output: true
        System.out.println(isPositiveAndEven.test(3)); // Output: false

        /** 3.or(Predicate<? super T> other) */
        Predicate<Integer> isGreaterThanTen = num -> num > 10;
        Predicate<Integer> isPositiveOrGreaterThanTen = isPositive.or(isGreaterThanTen);
        System.out.println(isPositiveOrGreaterThanTen.test(8)); // Output: true
        System.out.println(isPositiveOrGreaterThanTen.test(15)); // Output: true
        System.out.println(isPositiveOrGreaterThanTen.test(-5)); // Output: false

        /** 4.negate()(opposite)  */
        Predicate<Integer> isNegative = isPositive.negate();// negate() means opposite
        System.out.println(isNegative.test(5)); // Output: false
        System.out.println(isNegative.test(-3)); // Output: true


    }

}
