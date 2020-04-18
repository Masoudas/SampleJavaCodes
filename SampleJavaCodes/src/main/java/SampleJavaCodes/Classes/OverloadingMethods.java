package SampleJavaCodes.Classes;

/**
 * It's very important to note that the overloaded method 
 * is chosen at COMPILE TIME. Why? Because all variable
 * types are determined at compile time. This is not the case
 * for method overriding, where dynamic method dispatching allows
 * run-time assignment, meaning the underlying reference becomes
 * important. See EffectiveJava/Methods/3_UseOverLoadingJudicously
 */

public class OverloadingMethods{
    // Overload the methods.
    public void name() {
        System.out.println("Ey!");
    }

    public void name(String str) {
        System.out.println("Ey overloaded!" );
    }

}


/**
 * What happens when we overload primitive types with their class counterparts?
 * Well, the methods are called properly and there's no problem. So no confusion.
 */
class OverloadingPrimitiveTypes{
    public void overload(int x) {
        System.out.println("inside primitive type");   
    }    
    public void overload(Integer x) {
        System.out.println("Inside non-primitive type");
    }

    public static void main(String[] args) {
        new OverloadingPrimitiveTypes().overload(1);
        new OverloadingPrimitiveTypes().overload(new Integer(1));
    }
}

/**
 * The same situation even when the type is defined as generic.
 * But very interesting cases of confusion can happen, as is for example the case 
 * with List.remove(). See EffectiveJava/Methods/3_UseOverLoadingJudicously.
 */
class OverloadingPrimitiveTypesWithGeneric<U>{
    public void overload(int x) {
        System.out.println("inside primitive type");   
    }    
    public void overload(U x) {
        System.out.println("Inside non-primitive type");
    }

    public static void main(String[] args) {
        new OverloadingPrimitiveTypesWithGeneric<Integer>().overload(1);
        new OverloadingPrimitiveTypesWithGeneric<Integer>().overload(new Integer(1));
    }
}


/**
 * Also don't forget that when calling overloead methods with primitive types, the literals
 * are important. So for example, here the long method is never called!
 */

class CallOverloadedWithPrimitives{
    public void overload(int x) {
        System.out.println("inside int type");   
    }    
    public void overload(long x) {
        System.out.println("Inside long type");
    } 

    public static void main(String[] args) {
        new CallOverloadedWithPrimitives().overload(100);
        new CallOverloadedWithPrimitives().overload(1004342342);
    }

}
