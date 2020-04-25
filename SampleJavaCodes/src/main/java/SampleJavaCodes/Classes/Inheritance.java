package SampleJavaCodes.Classes;


// Very important issue that I forgot: Note that constructors are not inherited. This is because constructors are meant to return an
// instance of the class they belong to (which is why they have the same name as class), hence ineriting them would
// cause confusion. Note that even the default constructor is not inherited, it is just executed dduring inheritance.

class A{
    protected static int a; // The static may have it's own modifiers, which will give it the desired treatment during inheritance.
                            // When an static is inherited, it is shared even with the superclasses! Jesus I didn't know that!
    
    private int val = 10; // The private integer maybe accessed by a public method, in which case it better be initialized.

    public void readVal(){
        System.out.print(val);
    }
}

/**
 * Inheritance
 */
class B extends A {
    public B(){
        a = 5;
    }
    
    public static void main(String[] args) {
        B.a = 20;
        System.out.println(B.a);
            
        System.out.println(A.a);

        B b = new B();
        b.readVal();
    }
}



