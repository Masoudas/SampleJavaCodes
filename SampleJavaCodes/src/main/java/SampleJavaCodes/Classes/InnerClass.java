// Inner classes are defined inside another class. They have access to all members of the outer class (even private),
// the reverse however is not true. Inner classes can be static too, in which case they cannot have access to the outer class.
package SampleJavaCodes.Classes;

class OuterClass{
    private int x = 5;

    private void someMethod() {
        System.out.print("Something");
    }

    static void staticMethod(){
        System.out.print("Something");
    }

    class InnerClass{
        public InnerClass(){
            x = 20;
            someMethod();
        }
    }

    static class StaticInnerClass{
        public StaticInnerClass(){
            staticMethod();
        }
    }

}