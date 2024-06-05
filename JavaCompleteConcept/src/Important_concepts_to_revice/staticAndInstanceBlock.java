package Important_concepts_to_revice;

import java.util.HashSet;
/**       Order of execution

 This code demonstrates the use of static and instance blocks in Java, along with constructors and object creation. Here's a brief explanation of what each part does:

 staticAndInstanceBlock class:

 1.Contains a static block (executed when the class is loaded) that prints "parent static block".
 2.Contains an instance block (executed when an instance of the class is created) that prints "parent instance block".
 3.Contains a constructor that prints "parent constructor".


 base class (extends staticAndInstanceBlock):

 1.Contains a static block that prints "child static block".
 2.Contains an instance block that prints "child instance block".
 3.Contains a constructor that prints "child class constructor" and then prints this, which is a reference to the current object being created.
 Man class (main class):

 Creates an instance of base class (base b = new base();) and prints the object (System.out.println(b);).

 */

public class staticAndInstanceBlock {
    static {
        System.out.println("parent static block");
    }
    {
        System.out.println("parent instance block");
    }
    staticAndInstanceBlock(){
        System.out.println("parent constructor");
    }

}
class base extends staticAndInstanceBlock{
    static {
        System.out.println("child static block");

    }
    {
        System.out.println("child instance block");

    }
     base(){
        System.out.println("child class constructor");
         System.out.println(this);
    }
}

class Man{
    public static void main(String args[]){
        base b = new base();
        base b2 = new base();
        base b3 = new base();

        System.out.println(b);
        System.out.println(b2);
        System.out.println(b3);

        HashSet<base>h1 = new HashSet<>();

        h1.add(b);
        h1.add(b2);
        System.out.println(b.equals(b2));
        System.out.println("size of list "+h1.size());
    }
}
