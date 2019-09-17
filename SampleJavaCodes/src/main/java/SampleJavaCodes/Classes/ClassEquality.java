// Comparison of class referenece values is called shallow comparison.
// Comparison of class content is called deep comparison.

// When using the == for checking to reference values, because we are just comparing the actual memory,
// if the two classes are stored in the same place, the answer would be true. The equals non-overridden equals method does the same thing!

// To make a deep comparison, one needs to override the equals method.
// To compare

package SampleJavaCodes.Classes;

class RefClass{
    public static void main(String[] args) {
        RefClass a = new RefClass();
        RefClass b = a;

        RefClass c = new RefClass();

        System.out.println(a == b); // This would be true
        System.out.println(a == c); // This would be false
        
        System.out.println(a.equals(b));    // This would be true.
        System.out.println(a.equals(c));    // This would be true.

        System.out.println(a instanceof RefClass);   // This would be true.
    }
}