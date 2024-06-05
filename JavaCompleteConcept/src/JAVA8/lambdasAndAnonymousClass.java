package JAVA8;
// lambda functions can only be used with interfaces
public class lambdasAndAnonymousClass {

    public static void main(String args[]){

        // Anonymous class
        fiface fifaceObj = new fiface() {
            @Override
            public int itm(int x) {
                return 0;
            }
        };

        // This is lambda expression
        fiface fifaceobj2 = (x)->{return x*x;};


        abs absObj = new abs() {
            @Override
            public int sbsm(int x, String y) {
                return 0;
            }
        };

        siface siface = ()->{
            System.out.println("Interface related to this" +
                    " expression have one public method and others static, private, default ");
        };
    }
}


/** .............Given below is just a normal functional interface................. */
interface fiface{
    int x = 0;
    //by default all the methods of interface are public
    int itm(int x);

}

/**...............This is the interface face with some fact...........................*/

interface siface{
    //In interface You can not declare any variable as private and also initialization is compulsory
    String st = null;
    public void nmt();


    //protected int pit(); protected methods are not allowed inside interface
    // static and private and default method in interface should have body
    static String stm() {
        return null;
    }
    private String ptm(){
        return "ptm";
    }
    default int pit() {
        // Default method in interface is used to access private methode indirectly as they can be inherited by child.
        System.out.println("Inside default method");
        ptm();
        System.out.println(ptm());
        return 0;
    }
}
abstract class abs{

    // you have to write abstract in order to make method abstract
    abstract public int sbsm(int x, String y);
    public static void absm1(){}
    final static void absm2(){}

    private static final void absm3(){}
    // can not make variable to be abstract
    int var;

}

class lam extends abs{
  public static void lamm(){
      System.out.println("This is a normal class");
  }

    @Override
    public int sbsm(int x, String y) {
        return 0;
    }
    abs abs = new lam();
}


/**...............Here are the classes implementing interfaces...........................*/

class imp_fiface implements fiface{

    @Override
    public int itm(int x) {
        return 0;
    }
}
class imp_siface implements siface{
    public static void main(String args[]){
        imp_siface obj = new imp_siface();
        siface siface = new imp_siface();
        System.out.println( obj.pit());
        //Note that obj of this class we can call method of parent interface and that method can call private method
        // inside that interface.
    }

    @Override
    public void nmt() {

    }

    @Override//This method  implementation of a default method and there fore it is optional
    public int pit() {
        return siface.super.pit();
    }
}

