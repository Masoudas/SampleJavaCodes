package SampleJavaCodes.Basics;

import java.util.List;

class Initialization {
    /**
     * Primitive types have to be initialized, otherwise they don't contain any value,
     * and using them results in compilation error.
     */
    public static void primitiveTypes() {
        int x;
        double y;

        // System.out.println(x);   // Error
        // System.out.println(y);   // Error
    }

    // The same story as primitive types goes for reference types.
    public static void referenceTypes() {
        int[] x;

        // System.out.println(x);
        
    }

    // Array of primitive types are initialized to zero.
    // Array of reference types to null.
    public static void arrayInitialization() {
        int[] arrPrimitive = new int[2];
        String[] arrReference = new String[2];

        System.out.println(arrPrimitive[0]);
        System.out.println(arrReference[0]);
    }

    public static void main(String[] args) {
        arrayInitialization();
    }
    
}