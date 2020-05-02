package SampleJavaCodes.LangModule.Clonable;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * The clonable interface is used to copy an object.
 * As we see in the documentation of the clone method, the clone method
 * initializes a new instance of the class, with exactly the same content as the
 * original class. This means for example that the mutable fields of the class will
 * be copied. 
 * 
 * Note that Cloneable does not have any methods, what we override is the clone 
 * method of the Object class, which is protected, which we turn public (OMG!).
 * In fact when we cast to Cloneable, we don't see the clone method!
 * 
 * 
 * The array we define in this example is cloned, because the clone method on it
 * is called, so are the primitive types. Yet for example for the List, even though
 * the actuall dictionary is copied, the references inside of it are not.
 * 
 */
class Basics implements Cloneable {
    int[] arr1 = {1};
    ArrayList<int[]> table = new ArrayList<>();

    public Basics() {
        table.add(new int[]{2});
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Basics b1 = new Basics();
        Basics b2 = (Basics)b1.clone();

        Cloneable b3 = b1;
        //b3.clone();
        
        b2.arr1[0] = 2;
        System.out.println("After cloning, the class reference is new " + (b1 != b2) + " but not always!");
        System.out.println("The type of the class is equal " + (b1.getClass() == b2.getClass()) +  " but not always!");
        System.out.println("After cloning, an array if primitives is NOT copied " + (b1.arr1[0] == b2.arr1[0]));
        System.out.println("After cloning, a list is NOT copied " + (b1.table == b2.table));
    }
}