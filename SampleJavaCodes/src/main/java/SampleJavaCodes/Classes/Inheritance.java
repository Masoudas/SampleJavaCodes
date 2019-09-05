package SampleJavaCodes.Classes;

class A{
    protected static int a; // The static may have it's own modifiers, which will give it the desired treatment during inheritance.
}

/**
 * Inheritance
 */
class B extends A {
    public B(){
        a = 5;
    }
    
}