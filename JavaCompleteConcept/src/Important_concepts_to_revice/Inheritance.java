package Important_concepts_to_revice;

public class Inheritance {
}


class Animal {

    int a = 12;
    void sound() {

        System.out.println("Animal makes a sound");

    }

}

class Dog extends Animal {

    int a = 13;
    void sound() {

        System.out.println("Dog barks");

    }

}

class Cat extends Animal {

    int a = 14;
    void sound() {

        System.out.println("Cat meows");

    }

}

    class TestUpcasting {

    public static void main(String[] args) {

        Animal a; // Reference of superclass

        a = new Dog(); // Upcasting (Dog is automatically upcasted to Animal)

        a.sound(); // Calls the Dog class method

        a = new Cat(); // Upcasting (Cat is automatically upcasted to Animal)

        a.sound(); // Calls the Cat class method

    }

}