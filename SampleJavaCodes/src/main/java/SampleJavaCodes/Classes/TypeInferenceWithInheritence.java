/*
Would there be any confusion with type inference with Inheritance? I suppose not!
*/

package SampleJavaCodes.Classes;

class A1{

}

class B1 extends A1{
    int a = 1;
}

class C1 extends B1{
    int c = 10;

    // With this static factory however, the return type is always A, so we should be careful when using type inference
    public static A1 factory(int which) {
        switch (which){
            case 0:
                return new A1();
            case 1:
                return new B1(); 
            case 2:
                return new C1(); 
            
            default:
                return new C1();
        }        
    }

    public static void main(String[] args) {
        // The constructors are the same for all classes, however, there's no problem when resolving type.
        
        var c = new C1();
        System.out.println(c.c);

        var c1 = C1.factory(2);  // Eventhough the class type is C, because the return type is A, variable is considered A.
        //System.out.println(c1.c);   // This would be wrong.
       // C c2 = (C)c1; // This cast takes care of it.

    }
}

