package Important_concepts_to_revice;

import java.util.List;

/** Generic not only provide flexibility but also provide type safety */
public class GenericsInJava {
    public static void main(String args[]){
        Printer<Integer> printer = new Printer<>(23);
/**     <Integer> after class name and <> new class_name are necessary to give compiler idea what will be the type of generic class*/
        printer.print();
        Printer<Double> obj = new Printer<>(12.1);
        obj.print();

        printer2<dog> printer2 = new printer2<>(new dog());
        printer2.print();

        pList(List.of(1,2,3));
        pListTwo(List.of(new cat(),new dog()));

    }


    /** Java also support method level generic*/
    private static <E,S> E shout(E thingToShout, S otherThings){
    /**  here <E,S> are the type of parameter its going to accept and E is return type.*/
        System.out.println(thingToShout + "!!!!!!");
        System.out.println(otherThings+ "!!!!!!");
        return thingToShout;
    }


    /** Wildcard , this is one of the important topic to remember.
        It is used when we dont know exactly which kind of data type is going to come lets say from front end.*/
    private static void pList(List<?> myList){
        /** This ? is wild card */
        System.out.println(myList);
    }

    private static void pListTwo(List<? extends animal> myList){
        System.out.println(myList.toString());
    }
}




class Printer<T>{
    T thingToPrint;
    public Printer(T thingToPrint){
        this.thingToPrint = thingToPrint;
    }
    public void print(){
        System.out.println(thingToPrint);
    }
}


class animal{}

class cat extends animal{
    String name = "snow";
}

class dog extends animal{
    String name = "tommy";
}

class printer2<T extends animal>{ /**  When you declare class Printer2<T extends Animal>,
                                      you are restricting the type parameter T to be a subtype of Animal Only. */
    T thingToPrint;
    public printer2(T thingToPrint){
        this.thingToPrint = thingToPrint;
    }
    public void print(){
        System.out.println(thingToPrint);
    }
}
