/* 
To implement abstract methods, we use the keyword abstract right before the declaration of the method.
Note that a class with an abstract method must be declared abstract.

Can an abstract method be private? Surely not!
A class that does not implement all methods of an abtract superclass must be declared abstract itself.
Abstract classes can be used as reference variables though.
*/

package SampleJavaCodes.Classes;

abstract class AbstractBase{
    //abstract private void name();
    abstract protected void p1();
    abstract void p2();
    abstract public void p3();
}

class Implementer extends AbstractBase{

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