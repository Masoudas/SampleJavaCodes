// As mentioned elsewhere, classes with no modifier are public only within the package.\
// Another two keywords for class are abstract and final. Final does not allow a class to be inherited.

package SampleJavaCodes.Classes;

class A 
{
    protected int x = 20;
}

final class B extends A{
    protected int b = 20;
}

// class C extends B      This is not allowed.