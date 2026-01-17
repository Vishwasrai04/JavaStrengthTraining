package JAVA8.MethodReference;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Types of Method References
 * There are four main types of method references in Java:
 *
 * Static Method Reference: Syntax: ClassName::staticMethodName
 *
 * Example: Integer::parseInt is a reference to the parseInt static method of the Integer class.
 *
 *
 * Instance Method Reference on a Particular Object: Syntax: objectInstance::instanceMethodName
 *
 * Example: If str is an instance of String, then str::length is a reference to the length method of the str object.
 *
 *
 * Instance Method Reference on an Arbitrary Object of a Particular Type: Syntax: ClassName::instanceMethodName
 *
 * Example: String::length is a reference to the length instance method of any String object.
 *
 *
 * Constructor Reference: Syntax: ClassName::new
 *
 * Example: ArrayList::new is a reference to the constructor of the ArrayList class.
 * */

public class MethodReference {

    public static void main(String args[]){

        int[] arr = new int[]{1,2,3,4,5};
        Arrays.stream(arr).map(val -> Integer.parseInt(""));

        Comparator<employe>com = Comparator.comparing(employe::getName);

    }
}
class employe {
    int x;
    int name;

    public employe(int x, int name) {
        this.x = x;
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}