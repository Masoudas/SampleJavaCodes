package SampleJavaCodes.Classes;

// The variable with class identifier only contains the reference of the class in memory.
// In essence, when we allocate part of memory with the new keyword, we cannot nullify that part of the memory, we can
// only eliminate or assign references to it. Once there are no references to it, it will be eliminated.
// Each two such variables are  separate from one another. 

// It is however possible to call garbage collector of Java.
public class Fundamentals{  // No access modifier means the class is private.
    int var;    // No accuess modifier means that the variable is public
    void name() {   // No access modifer means public method.
        
    }
    public static void main(String[] args) {
        Fundamentals fundamentals = new Fundamentals();
        Fundamentals fundamentals2 = fundamentals;  // Now we refer to the same class.
        fundamentals.name();
        fundamentals = null; // fundamentals2 would still refer to the same object.

        System.gc();// Calling system garbage collector.
    }
}

