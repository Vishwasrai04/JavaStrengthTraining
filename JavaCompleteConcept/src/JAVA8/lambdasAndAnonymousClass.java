package JAVA8;

public class lambdasAndAnonymousClass {

    public static void main(String[] args) {

        /** --- 1. ANONYMOUS CLASS --- */
        // Works for both Interfaces and Abstract Classes.
        // It creates a nameless class file at compile time.
        SimpleInterface obj1 = new SimpleInterface() {
            @Override
            public int calculate(int x) {
                return x + 10;
            }
        };

        /** --- 2. LAMBDA EXPRESSION --- */
        // Only works for FUNCTIONAL INTERFACES (1 abstract method).
        // Cleaner syntax, no extra .class file created.
        SimpleInterface lambdaObj = (x) -> x * x;

        /* --- 3. ABSTRACT CLASS ANONYMOUS IMPLEMENTATION --- */
        BaseAbstract absObj = new BaseAbstract() {
            @Override
            public int process(int x, String y) {
                System.out.println("Processing: " + y);
                return x * 2;
            }
        };


        /* --- 4. NO-ARGUMENT LAMBDA --- */
        AdvancedInterface advLambda = () -> {
            System.out.println("Rule: Lambdas work if there is exactly one 'abstract' method.");
        };
    }
}


/**
 * RULE: Functional Interfaces can have:
 * 1. Exactly ONE abstract method.
 * 2. Multiple Static, Private, and Default methods.
 */
@FunctionalInterface
interface SimpleInterface {
    int MAX_LIMIT = 100; // Automatically: public static final

    int calculate(int x); // Automatically: public abstract

    static void utility() {
        System.out.println("Static methods don't need an instance.");
    }
}

interface AdvancedInterface {
    String DEFAULT_STATUS = "ACTIVE"; // Initialization is COMPULSORY

    void runTask(); // The single abstract method

    // PRIVATE: Used for internal logic shared between default methods
    private String logHelper() {
        return "[LOG INFO]: ";
    }

    // DEFAULT: Allows adding new methods to interfaces without breaking implementing classes
    default int performAction() {
        System.out.println(logHelper() + "Inside default method");
        return 0;
    }

    // STATIC: Cannot be inherited; called via AdvancedInterface.status()
    static String status() {
        return "Static Status";
    }
}

abstract class BaseAbstract {
    int instanceVar; // Unlike interfaces, variables can be non-static/non-final

    // You MUST use the 'abstract' keyword for methods without a body
    abstract public int process(int x, String y);

    public static void staticMethod() { }

    final void finalMethod() {
        System.out.println("Cannot be overridden by children");
    }
}

class Implementation extends BaseAbstract implements AdvancedInterface {
    @Override
    public int process(int x, String y) {
        return x;
    }

    @Override
    public void runTask() {
        System.out.println("Task Running");
    }

    // Overriding a default method is OPTIONAL
    @Override
    public int performAction() {
        // You can call the parent interface's default method like this:
        return AdvancedInterface.super.performAction();
    }
}