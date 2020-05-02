/*
To access members of the super class that are hidden by the subclass, we may use the super keyword.
It can either be:
1- Constructor: The line would be super(), in which case the constructor must be called first.
2- Members hidden by the derived class. This can be either fields or methods. Hence, and overridden member
or field of the super class can be accessed via the super keyword.

Super only goes one level higher, meaning we cannot access the superclass of a superclass using for
example super.super();

Note that even if the constructor of the superclass is not called, it will be executed (in this case the parameterless constructor will
be executed). The reason behind this is that we want all parameters to be initialized. The order of execution will be the order of hierarchy.
Hence, first the highest constructor is executed, and then we come down the hierarchy.

Note that super refers to the current instance of the superclass constructed with this class. It cannot 
be used to access static methods. For static methods, use method name directly. Although for fields,
to avoid ambiguity sometimes we need to use the super keyword, and that's fine.

*/

package SampleJavaCodes.Classes;

class A{
    private int x;
    public int y;

    public A() {
        System.out.println("Inside superclass A default constructor");
        x = 20;
        y = 20;
    }


    public void method1() {
        System.out.println("Inside superclass");
    }

}

/**Here we see how we can access overddien field and methods. */
class B extends A{
    public int y;
    public B() {    
        super();    // This would be the constructor of the superclass.
        this.y = super.y;   // Accessng the y of super class.
        System.out.println("Inside superclass B default constructor");
    }

    public B(int x) {    
        System.out.println("Inside superclass B overridden constructor");
    }

    @Override
    public void method1() {
        super.method1();    // We execute method one of the superclass.
        System.out.println("Inside inherited class");
    }
    
    public static void main(String[] args) {
        B b = new B();
        b.method1();
    }
}

class C extends B{
    public  C() {
        //super.super();    // Does not make sense!
        // However, upon instantiating this class, the default constructors of the superclasses will be executed.
    }

    public C(int y) {
        // The default constructors will be executed before this constructor.
        System.out.println("Inside class C");
        this.y = y;
    }

    public C(int y, int z) {
        // If however I call a particular constructor of superclass, then default constructors up to that constructor will
        // be executed, then the superclass constructor, and then this constructor.
        super(10);
        System.out.println("Inside class C");
        this.y = y;
    }

    public static void main(String[] args) {
        C c = new C(20);

        C c1 = new C(20, 30);

    }
}


