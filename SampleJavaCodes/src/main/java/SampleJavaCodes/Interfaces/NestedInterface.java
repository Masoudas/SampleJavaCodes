package SampleJavaCodes.Interfaces;

// By nested interface, we mean an interface designed as part of another class or interface.
// Such declaration can get the public, private or protected access modifiers.

class A {
    protected interface Sample{
        public void method();
    }

}

/**
 * NestedInterface
 */
public class NestedInterface implements A.Sample{
    @Override
    public void method() {
    }    
}