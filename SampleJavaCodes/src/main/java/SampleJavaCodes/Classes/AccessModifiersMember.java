// To restrict access, there are four modifiers, namely public, private, protected and no access modifier.
// The protected case is different from C#, in the sense that it only protects against non-inherited class
// outside the package. In other words, if a class is inherited (even outside the package), the protected parameters
// are visible. The protected parameters are also public inside the class even without Inheritance.
// When we specify no access modifier, it is public inside the class, and is not visible outside the package.

package SampleJavaCodes.Classes;

class ExampleOfAccess{
    int x = 10; // This would not be seen outside the package.
    protected int y = 10;   // Only would not be seen by classes outside this package that do not inherit.

}

class A extends ExampleOfAccess{
    public A(){
        y = 20; // y is visible as mentioned.
    }
}