/**
 * The TreeSet class implements a tree like structure. It extends
 * the NavigableSet structure, and the elements are ascending.
 * Access and retrieval of data is quite fast with this method, so for
 * very large sets of data it does make sence.
 * 
 * As the name is TreeSet, it should be obvious that we are dealing
 * with sets, so repetitive elements are not allowed.
 */

package SampleJavaCodes.UtilLibrary;

import java.util.SortedSet;
import java.util.TreeSet;

class TreeSetExample{
    public static void main(String[] args) {
        TreeSet<Double> tSet = new TreeSet<Double>(); 
        
        tSet.add(5.0);
        tSet.add(15.0);
        tSet.add(1.1);

        System.out.println(tSet);   // So this now wou;d be organized.

        // Now because the TreeSet implements the NavigatorSet, it is possible
        // to search for proximity.
        SortedSet<Double> sSet = tSet.subSet(4.0, 20.0);
        System.out.println(sSet);
    }
}