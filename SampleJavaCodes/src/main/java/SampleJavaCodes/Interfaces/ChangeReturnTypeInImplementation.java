package SampleJavaCodes.Interfaces;

import java.util.ArrayList;
import java.util.List;

// Note that when implementing an interface or with inhertance, the return type of methods can change,
// but it should be a subclass of the original method (so that it could contain the reference, like List and ArrayList here)
// For primitive types, this is not possible. Boxing and unboxing is also impossible. (There must be some problem
// that does not allow primitive types to change to reference types or other referene types.)

/**
 * 
 * However, if we have access to the BASE CLASS reference, the method
 * dispatching mechanism only looks at the base class signature. Hence, it
 * always assumes that the base class reference is returned.
 * 
 */

interface IReturnTypeCantChange {
    public List<Integer> iMethod();

    public int iPMethod();

    public int iPMethodForBoxing();

}

abstract class CReturnTypeCanChange<T> {
    T t;

    public int cMethod() {
        return 0;
    };

    abstract public T tMethod();
}

class IAndI extends CReturnTypeCanChange<Integer> implements IReturnTypeCantChange {

    @Override
    public ArrayList<Integer> iMethod() {
        return new ArrayList<>();
    }

    public int cMethod() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Integer tMethod() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int iPMethod() {
        return 0;
    }

    @Override
    public int iPMethodForBoxing() {
        return 0;
    }

    // This is not allowed
    // @Override
    // public double iPMethod() {
    // return 0;
    // }

    // This is impossible (why?)
    // @Override
    // public Integer iPMethodForBoxing() {
    // return 0;
    // }

}
