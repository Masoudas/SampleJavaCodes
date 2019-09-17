/*
Method overriding occurs only when the names and the type signatures of the two methods are identical. 
If they are not, then the two methods are simply overloaded

It is not necessary to use @override annotation everytime we override a method, however, it is highly recommended.

Dynamic method dispatch. Dynamic method dispatch is the mechanism by which a call to an overridden method is resolved at run time,
rather than compile time. Dynamic method dispatch is important because this is how Java implements run-time polymorphism.

What all this means is that when a method is overridden and we hold a reference of it using the base class, dynamic method dispatch
allow us to use the overridden method, not the superclass method!
*/

package SampleJavaCodes.Classes;

class A{
    public void callMe() {
        System.out.println("Call method A");
        
    }
}

class B extends A{
    @Override
    public void callMe() {
        System.out.println("Call method B");
    }
}

class C extends B{
    @Override
    public void callMe() {
        System.out.println("Call method C");
    }
    public static void main(String[] args) {
        A[] aHolder = {new A(), new B(), new C()};

        for (A a : aHolder) {
            a.callMe();
            
        }
    }
}

