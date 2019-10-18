/**
 * The LinkedHashSet is the same as HashSet, the only difference being
 * that the order at which elements are set are kept inside of the file.
 * This allows insertion-order iteration over the set
 * Also, it takes only one generic as argument, which implies that the keys
 * cannot be general.
 */

package SampleJavaCodes.UtilLibrary;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;

class LinkedHashSetExample{
    public static void main(String[] args) {
        LinkedHashSet<Double> lSet = new LinkedHashSet<Double>(); 

        lSet.add(5.5);
        lSet.add(15.5);

        System.out.println(lSet);   // We see that when printing, the elements have the same order
        // as when they are put.

        Iterator<Double> itr = lSet.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        
    }
}