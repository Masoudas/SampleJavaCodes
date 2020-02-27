package SampleJavaCodes.Classes;

class StaticVars{
    static int x;
    // We can define a static block to initialize a static variable.
    static {
        if (true){
            x = 5;
        }
        else {
            x = 10;
        }
    }
}

/*
There's no such thing as static classes in java.
static class StaticClass{

}
*/

/**
 * It is possible to access the static methods of an abstract class
 */

abstract class A{
    static public void name() {
        
    }
}

class B{
    public static void main(String[] args) {
        A.name();
        
    }
}

/**
 * Static methods can be overridden!
 * This however is not the case for interfaces!
 */

/**
 * StaticModifier
 */
class StaticModifier {

    public static void staticMethod() {
        System.out.println("This is the static method in the base class.");
    }
}

/**
 * InnerStaticModifier
 */
class InheritStaticMehtod {
    public static void staticMethod() {
        System.out.println("This is the overridden static method.");
    }

    public static void main(String[] args) {
        StaticModifier.staticMethod();
        InheritStaticMehtod.staticMethod();
    }
    
}