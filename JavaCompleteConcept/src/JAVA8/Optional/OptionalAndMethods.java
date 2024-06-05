package JAVA8.Optional;

import java.util.Optional;

public class OptionalAndMethods {

    public static void main(String args[]){

        Optional<String> nonEmptyOptional = Optional.of("Hello");
        Optional<String> nullableOptional = Optional.ofNullable(null);
        Optional<String>emptyOptional = Optional.empty();


        String s = nonEmptyOptional.get();// unsafe can throw null pointer exception
        nonEmptyOptional.isPresent();
        nonEmptyOptional.ifPresent(val-> System.out.println(val));
        nonEmptyOptional.orElse("Default value");


        Optional<String>transformed = nonEmptyOptional
                .map(String::toUpperCase);

        Optional<String>flattened = nonEmptyOptional
                .flatMap(x->Optional.of(x.toUpperCase()));

        Optional<String>filtered = nonEmptyOptional.filter(x->x.length()>5);


    }
}
