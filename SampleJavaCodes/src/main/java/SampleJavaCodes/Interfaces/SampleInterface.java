// The interface (not the methods) can only have the public and abstract access modifiers. Private is not allowed.
// If a class implements two interfaces that have the same method, then the same method is 
// used with both interfaces.


package SampleJavaCodes.Interfaces;

abstract interface InnerSampleInterface {
}

public interface SampleInterface{
    public void method1(SampleInterface iface);  // The method is not supposed to have a body, which is why we cannot place brackets here.
    //protected void method2();  // Protected method don't make sense, and are not accepted as modifiers.
    // Also static methods are not allowed.     
    
    public void method2();

    // Interfaces may also have static final variables too. They should be initialized as well.
    static final int x = 10;
}

// Also notice that when we implement an interface, we don't have to use the override keyword! However,
// it's good practice to do so!

class Implementer implements SampleInterface{

    @Override
    public void method1(SampleInterface iface) {
        System.out.println("Overridden method");
    }

    @Override
    public void method2() {
        // TODO Auto-generated method stub

    }
}

// We may also partially implement an interface, in which case we need to use Abstract keyword.

abstract class partialImplementer implements SampleInterface{
    @Override
    public void method1(SampleInterface iface) {
    }
}

