package Design_patterns.Structural;

// Client code
public class AdapterDesignPattern {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);
        target.request();
    }
}

// Target interface
interface Target {
    void request();
}

// Adaptee class (the class we want to adapt)
class Adaptee {
    public void specificRequest() {
        System.out.println("Adaptee's specific request");
    }
}

// Adapter class
class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void request() {
        adaptee.specificRequest();
    }
}


