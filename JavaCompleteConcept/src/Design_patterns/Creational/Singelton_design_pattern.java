package Design_patterns.Creational;

public class Singelton_design_pattern {
    private static Singelton_design_pattern singeltonDesignPattern;
    private Singelton_design_pattern(){

    }
    static public Singelton_design_pattern getInstance(){
        if(singeltonDesignPattern == null){
            singeltonDesignPattern = new Singelton_design_pattern();}
        return singeltonDesignPattern;

    }
}


// There are various variation of singleton design pattern this is the most efficient
// Below version is know as double check
 class Another_variation {
    private static Another_variation another_variation = null;
    private Another_variation(){}

    public static Another_variation getInstance(){
        if (another_variation==null){
            synchronized(Another_variation.class){
                if(another_variation == null){
                    another_variation = new Another_variation();
                }
            }
        }
        return another_variation;
    }

 }

 // Below variation is know as Eager initialization

class Eager{
    private static Eager eager = new Eager();
    private Eager(){}

    public static Eager getInstance(){
        return eager;
    }

}