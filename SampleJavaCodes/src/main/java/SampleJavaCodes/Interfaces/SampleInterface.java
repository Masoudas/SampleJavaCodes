/**
 * The interface (not the methods) can only have the public and abstract access modifiers. Private is not allowed. 
 * If a class implements two interfaces that have the same method, then the same method is used with both interfaces.
 * Inteface methods are by default public (and not paackage public, they are public.) 
 * 
 * There is no need to use public abstract before methods and public static final before constants of an interface.
 * First of all Interfaces are used to specify common methods for a set of unrelated classes for which every class will have a unique implementation. 
 * Therefore it is not possible to specify the access modifier as private since it cannot be accessed by other classes to be overridden. 
 * Second, Although one can initiate objects of an interface type but an interface is realized by the classes which implement it and not inherited. 
 * And since an interface might be implemented (realized) by different unrelated classes which are not in the same package therefore protected access modifier is not valid as well. So for the access modifier we are only left with public choice. 
 * Third, an interface does not have any data implementation including the instance variables and methods. If there is logical reason to insert implemented methods or instance variables in an interface then it must be a superclass in an inheritance hierarchy and not an interface. Considering this fact, since no method can be implemented in an interface therefore all the methods in interface must be abstract. 
 * Fourth, Interface can only include constant as its data members which means they must be final and of course final constants are declared as static to keep only one instance of them. Therefore static final also is a must for interface constants. 
 * So in conclusion although using public abstract before methods and public static final before constants of an interface is valid but since there is no other options it is considered redundant and not used.
 * */

package SampleJavaCodes.Interfaces;

abstract interface InnerSampleInterface {
}

public interface SampleInterface {
    public void method1(SampleInterface iface); // The method is not supposed to have a body, which is why we cannot
                                                // place brackets here.
    // protected void method2(); // Protected method don't make sense, and are not
    // accepted as modifiers.
    // Also static methods are not allowed.

    public void method2();

    // Interfaces may also have static final variables too. They should be
    // initialized as well.
    static final int x = 10;
}

// Also notice that when we implement an interface, we don't have to use the
// override keyword! However,
// it's good practice to do so!

class Implementer implements SampleInterface {

    @Override
    public void method1(SampleInterface iface) {
        System.out.println("Overridden method");
    }

    @Override
    public void method2() {
        // TODO Auto-generated method stub

    }
}

// We may also partially implement an interface, in which case we need to use
// Abstract keyword.

abstract class partialImplementer implements SampleInterface {
    @Override
    public void method1(SampleInterface iface) {
    }
}
