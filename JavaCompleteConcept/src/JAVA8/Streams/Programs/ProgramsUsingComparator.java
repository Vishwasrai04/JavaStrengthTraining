package JAVA8.Streams.Programs;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramsUsingComparator {
    public static void main(String args[]) {

        List<person> people = new ArrayList<>();
        person p1 = new person(1,"vish", "rai");
        person p2 = new person(2, "div", "kanuje");

        people.add(p1);
        people.add(p2);



        List<person> sortedPeople = people.stream()
                .sorted(Comparator.comparing(person::getLastName)
                        .thenComparing(person::getFirstName)
                        .thenComparing(per -> per.id))
                .collect(Collectors.toList());
    }
}

class person{
    int id;
    String firstName;
    String lastName;

    public person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
