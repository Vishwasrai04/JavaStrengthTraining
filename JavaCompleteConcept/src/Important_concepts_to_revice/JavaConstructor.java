package Important_concepts_to_revice;

public class JavaConstructor {
    public static void main(String args[]){
        Vehicle bmw = new car();

    }
}
class Vehicle{
    public Vehicle(){
        System.out.println("we are in vehicle object");
    }
}
class car extends Vehicle{
    public car(){
        System.out.println("we are in car object");
    }
}
