package Design_patterns.Creational;



/**
*                                       Factory Design Pattern
*
*       Product(Interface) - CocreateProduct1(Class),  CocreateProduct2(Class),  CocreateProduct3(Class)...n
*       Factory(Interface) - ConcreateFactory(class){  new object_of_CocreateProduct1, new object_of_CocreateProduct2, new object_of_CocreateProduct3 }


 *  The key idea behind the facto design pattern or factory method pattern is That each subclass(concreteFactory) can
 *  instantiate a different concrete class(concreteProduct) that implements the product interface.*/


interface product{
    public  void createProduct();
}

class concreateProduct1 implements product{

    @Override
    public void createProduct() {
        System.out.println("Product one is created");
    }
}

class concreateProduct2 implements product{

    @Override
    public void createProduct() {
        System.out.println("Product two is created");
    }
}

interface factory{
    public product createInstance(String productTYpe);
}
class concreateFactory implements factory{

    @Override
    public product createInstance(String productTYpe) {
        if(productTYpe.equals("concreateProduct1")){
            return new concreateProduct1();}
        else if (productTYpe.equals("concreateProduct2")) {
            return new concreateProduct2();
        }
        return null;
    }
}
public class FactoryDesignPattern {



    product product1 = new concreateFactory().createInstance("concreateProduct1");
    product product2 = new concreateFactory().createInstance("concreateProduct2");




}
