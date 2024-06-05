package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/** Comparable is used for natural order of sorting example while we use sort method in collection frame work*/
public class ComparatorAndCoparable {

  public static void main(String args[]){
      List<Person>list = new ArrayList<>();
      Person p1 = new Person(1,"vishwas", "pune");
      Person p2 = new Person(6,"Haapy", "pune");
      Person p3 = new Person(2,"Ranu", "ujjain");
      Person p4 = new Person(8,"Divya", "ujjain");
      Person p5 = new Person(10,"Geeta", "sehore");

      list.add(p1); list.add(p2);  list.add(p3);
      list.add(p4); list.add(p5);
      /**Apply simple comparable, you can extend your class(person) and change compare to methode according to you*/
      Collections.sort(list);


      /** Now comparator, Also comparator provides various in built methods  to use*/
      /** based on id*/
      Comparator<Person> idComparatorInt = Comparator.comparingInt(p -> p.id);
      Collections.sort(list, idComparatorInt);
      System.out.println(list.stream().map(val->val.id).collect(Collectors.toList()));

      /** based on name*/
      Comparator<Person> idComparatorString = Comparator.comparing(pers -> pers.name);
      Collections.sort(list, idComparatorString);
      System.out.println(list.stream().map(val->val.name).collect(Collectors.toList()));

      /** Sorting using Custom Comparator*/
      helper help = new helper();
      Collections.sort(list, help);
      System.out.println(list.stream().map(val->val.id).collect(Collectors.toList()));




  }


}

class Person implements Comparable<Person> {

    int id;
    String name;

    String address;

    public Person(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }


    @Override
    public int compareTo(Person o) {
 //        return this.name.compareTo(o.name);
           return Integer.compare(this.id, o.id);
    }
    /** To use comparable we have to change existing calls we can avoid this by using comparator*/
}

 class helper implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
         if(o1.address.equals(o2.address)){return 1;}
         else{return -1;}
    }
}