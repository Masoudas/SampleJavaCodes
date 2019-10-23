/**
 * All collection classes provide an iterator method, which can be used
 * to iterate over the elements of the class.
 * 
 * The Iterator Interface is very simple. Note however that when it returns
 * an iterator, it is not referenced to the object, just a copy.
 * 
 * ListIterator however has a set method, that can actually change the content.
 * 
 * 
 */

package SampleJavaCodes.UtilLibrary;

import java.util.*;

class IteratorExample{
    public static void main(String[] args) {
        ArrayList<Double> lSet = new ArrayList<Double>(); 

        lSet.add(5.5);
        lSet.add(15.5);

        System.out.println(lSet);   // We see that when printing, the elements have the same order
        // as when they are put.

        Iterator<Double> itr = lSet.iterator();
        while(itr.hasNext()){
            Double d = itr.next();
            System.out.println(d);
            d = 20.0;   // Again, note that this does not work, because we return a copy of the element
        }

        System.out.println(lSet);

        ListIterator<Double> lIterator = lSet.listIterator();
        while(lIterator.hasNext()){
            Double d = lIterator.next();
            d = 20.0;   // 
            lIterator.set(d);    
        }

        System.out.println("Just for fun, printing backwards.");
        while(lIterator.hasPrevious()){
            System.out.println(lIterator.previous());
        }
    }
}