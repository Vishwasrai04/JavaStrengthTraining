package JAVA8.Streams.Programs;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/** Assume you have list of employee you have to find employee with the highest salary in each department*/
public class HeighestSalaryEmploye {
    public static void main(String args[]){

        List<Employee> employeeList = new ArrayList<>();

        // Initialize the list manually with 10 iterations
        for (int i = 1; i <= 10; i++) {

            int x = i%3;
            // Create sample Employee objects with manual values
            Employee employee = new Employee("Employee " + i, i, 50000 + (i * 1000), "dep"+x); // Incrementing salary for each employee
            employeeList.add(employee);
        }

   /**            Here we will write the stream functions              */

        Map<String, List<Employee>> collect = employeeList.stream().collect(Collectors.groupingBy(employee -> employee.getDepartment()));
//        System.out.println(collect);
//        collect.forEach((key, value)-> System.out.println(key +" = "+ value));
        /**lets create comparator for getting max salary */

        Comparator<Employee> com= Comparator.comparing(Employee::getSalary);
        Map<String, Optional<Employee>> collect1 = employeeList.stream().collect(Collectors.groupingBy(employee -> employee.getDepartment(), Collectors.reducing(BinaryOperator.maxBy(com))));
        System.out.println(collect1);


    }
}

 class Employee {
    private String name;
    private int id;
    private double salary;
    private String department;

    // Constructor
    public Employee(String name, int id, double salary, String department) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.department = department;
    }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public double getSalary() {
         return salary;
     }

     public void setSalary(double salary) {
         this.salary = salary;
     }

     public String getDepartment() {
         return department;
     }

     public void setDepartment(String department) {
         this.department = department;
     }

     @Override
     public String toString() {
         return "Employee{" +
                 "name='" + name + '\'' +
                 ", id=" + id +
                 ", salary=" + salary +
                 ", department='" + department + '\'' +
                 '}';
     }
 }