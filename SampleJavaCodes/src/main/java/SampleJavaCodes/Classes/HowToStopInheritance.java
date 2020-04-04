package SampleJavaCodes.Classes;

/** 
 * As we know, to stop inheritance:
 * 1- One famous way to stop inheritance is by using the final keyword.
 * 2- We can stop inheritance by declaring all class constructors private!
*/
final class FinalClass {
    
}

// This as we know is impossible.
// class InheritFinalClass extends FinalClass{

// }


class PrivateConstructos{
    private PrivateConstructos(){

    }
}

// The following is also impossible, and this is why singletons cannot be inherited!
// class InheritPrivateConstructors extends PrivateConstructos{
//     public InheritPrivateConstructors(int x) {
//         super();
//     }
// }