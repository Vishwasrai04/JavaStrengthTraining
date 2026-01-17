package JAVA8.Consumer_Supplier_Predicate_Function;

import java.util.function.Supplier;

public class supplier {
    public static void main(String args[]){
       Supplier<Integer> supplier = new Supplier<>() {
            @Override
            public Integer get() {
                System.out.println("inside supplier");
                return 123;
            }
        };

        System.out.println(supplier.get());
    }

}
