// It is possible to implement in an interface for two reasons:
/*
 * 1- So that when a method is later on added to the interface, the code that
 * has already used the interface would not be broken. 2- When a class that
 * inherits the interface does not need to implement a method, then that method
 * can have a default implementation in the interface that does nothing. In that
 * case, the class that inherits the interface does not have to implement that
 * method (would it be hidden in the inherited class?)
 * 
 * Because an interface cannnot hold data, it does not have memory. It is very
 * important to remember that. Hence, we need to define data as static.
 * 
 * One other thing: An interface method that ends in curly brackets have a
 * default implementation. So we should not put brackets there.
 * 
 * We may also define and implement static methods in the interface, in which
 * case the static must have an static implementation.
 * 
 * 
 */


package SampleJavaCodes.Interfaces;

/**
 * DefaultAndStaticMethods
 */
public interface DefaultAndStaticMethods {
    public static void staticMethod() {
        System.out.println("This is a static method in the interface.");
    }
    
}

/**
 DefaultAndStaticMethods
 */
class InnerDefaultAndStaticMethods implements DefaultAndStaticMethods{
    public static void staticMethod() {
        System.out.println("The static method is overridden in the class that implements it.");
    }
    
    public static void main(String[] args) {
        InnerDefaultAndStaticMethods.staticMethod();
        DefaultAndStaticMethods.staticMethod();
    }
}