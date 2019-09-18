/**
 * It is possible to define generic parameters inside of a class method,
 * as shown in the examples below:
 * 
 * For example, in the following class, we declare an static method which would check and see if
 * a given value is inside of an array. Note that 
 * We extend the comparable interface here. This interface is implemented by classes that allow
 * some form of ordering (sweet!). Notice the use of generics in the extension.
 * 
 * I did not understand this comparable interface.
 * 
 * Notice how the generic method is called. Basically, it is like the other methods!
 */

package SampleJavaCodes.Generics;

/**
 * GenericMethods
 */
class GenericMethods {
    static <T extends Comparable<T>, U extends T> boolean isIn(T t, U[] u){
        for (int i = 0; i < u.length; i++)
            if (u[i] == t) return true;
        
        return false;
    }

    public static void main(String[] args) {
        Integer i = 5;
        Integer[] arr = {1, 2, 3, 4, 5};

        System.out.println(GenericMethods.isIn(i, arr));
    }

    
}

// It is also possible for constructors to be generic, even though the classes are not.
class GenericConstructors{
    private double val;
    <T extends Number>GenericConstructors(T t){
        this.val = t.doubleValue();
    }

    public static void main(String[] args) {
        GenericConstructors gc = new GenericConstructors(10);
    }
}

