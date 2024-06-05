package Collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMap_Iteration_and_Methods {
    public static void main(String[] args) {
        HashMap<Integer, Student> studentHashMap = createAndInitializeMap();
        /** Here are the five ways of initializing hashmap */

        /** First way using - Iterator*/
        Iterator< Map.Entry<Integer, Student>> iterator = studentHashMap.entrySet().iterator();
        while(iterator.hasNext()){

            Map.Entry<Integer, Student> x= iterator.next();
            x.getKey();
            x.getValue();
        }

        /** Second way using - For-Each Loop with EntrySet*/

        for(Map.Entry<Integer, Student> et : studentHashMap.entrySet()){ // here Entry is inner class(Actually interface) inside Map Interface
            et.getKey();
            et.getValue();


        }



        /** Third way using - For-Each Loop with KeySet*/

        for(Integer x : studentHashMap.keySet()){
            Student value = studentHashMap.get(x);
        }

        /** Fourth way using - For-Each Loop with values*/

        for(Student s: studentHashMap.values()){
            Student values = s;
        }

        /** Fifth way by using - Streams*/

        studentHashMap.forEach((key, val) ->{

            int x = key;
            Student v = val;



        });


    }


    public static HashMap<Integer, Student> createAndInitializeMap(){
        // Create five Student instances using the create method
        Student student1 = Student.create("John", 20);
        Student student2 = Student.create("Alice", 22);
        Student student3 = Student.create("Bob", 21);
        Student student4 = Student.create("Emily", 23);
        Student student5 = Student.create("David", 19);

        // Initialize a HashMap with five entries
        HashMap<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(1, student1);
        studentMap.put(2, student2);
        studentMap.put(3, student3);
        studentMap.put(4, student4);
        studentMap.put(5, student5);

        return studentMap;
    }


}



class Student {
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Static method to create a Student instance
    public static Student create(String name, int age) {
        return new Student(name, age);
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
