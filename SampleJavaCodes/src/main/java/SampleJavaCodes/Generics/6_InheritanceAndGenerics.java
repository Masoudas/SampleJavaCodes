/**
 * Classes with generics can be inherited as well.
 * The key difference between generic and non-generic hierarchies 
 * is that in a generic hierarchy, any type arguments needed by a 
 * generic superclass must be passed up the hierarchy by all subclasses.
 * In other words, when we write the word extend SuperClass<T>, the type of
 * T should be determined b the subclass. This can either be another generic,
 * or it can be an explicit type. In Either case, the constructor
 * of the super class must explicitly be called.
 */

package SampleJavaCodes.Generics;

class SuperClass<T extends Number> {
    public SuperClass(T t){
        System.out.println(t.floatValue());
    }
}

/*
* Example: In this example, the super class is implemented in the float 
* type. Now because the constructor of the super class is always executed
* we need to limit the constructor to the float type as well.
*

*/
class SubClass extends SuperClass<Float> {

    public SubClass(Float t) {
        // Why is there need to explicitly call this super class?
        super(t);
    }

}

class SubClass1<T extends Number> extends SuperClass<T> {

    public SubClass1(T t) {
        super(t);
        // TODO Auto-generated constructor stub
    }



}