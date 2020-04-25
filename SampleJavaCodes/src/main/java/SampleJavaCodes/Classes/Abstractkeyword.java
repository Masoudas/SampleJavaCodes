/* 
To implement abstract methods, we use the keyword abstract RIGHT BEFORE the declaration of the method
(otherwise we would get compile issues).
Note that a class with an abstract method must be declared abstract.

Can an abstract method be private? Surely not!
A class that does not implement all methods of an abtract superclass must be declared abstract itself.
Abstract classes can be used as reference variables though.
*/

package SampleJavaCodes.Classes;

abstract class AbstractBase {
    // abstract private void name();
    abstract protected void p1();

    abstract void p2();

    abstract public void p3();
}

class Implementer extends AbstractBase {

    @Override
    protected void p1() {
        // TODO Auto-generated method stub

    }

    @Override
    void p2() {
        // TODO Auto-generated method stub

    }

    @Override
    public void p3() {
        // TODO Auto-generated method stub

    }

}

/**
 * Note that when overriding methods, the return type can change (because it's
 * not part of the signature). And we can get the overriden type from child
 * classes.
 * 
 * However, if we have access to the BASE CLASS reference, the method
 * dispatching mechanism only looks at the base class signature. Hence, it
 * always assumes that the base class reference is returned.
 */

abstract class Base {
    public abstract Number overRidden();
}

class Derived1 extends Base {

    @Override
    public Integer overRidden() {
        return new Integer(1);
    }

    public static void main(String[] args) {
        Integer integer = new Derived1().overRidden();

        Base base = new Derived1();
        Integer int1 = base.overRidden();   // This is where we get the error!!!
    }

}