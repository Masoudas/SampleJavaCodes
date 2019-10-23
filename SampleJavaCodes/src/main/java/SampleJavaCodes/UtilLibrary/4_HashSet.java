/**
 * HashSet extends AbstractSet and implements the Set interface. It creates a
 * collection that uses a hash table for storage.
 * 
 * NOTE THAT THE ELEMENTS ARE STORED IN NO PARTICULAR ORDER.
 * 
 * HashTable is pretty much the same, except for the 
 */

package SampleJavaCodes.UtilLibrary;


import java.util.*;

class HashSetExample{
    public static void main(String[] args) {
        Hashtable<String, Integer> hashtable = new Hashtable<String, Integer>(); 

        hashtable.put("First", 5);
        hashtable.put("Second", 10);
        hashtable.put("Third", 10);
        hashtable.put("Fourth", 10);

        System.out.println(hashtable);  // Note that when printing, the elements would be printed
        // in no particular order (duh!)

        Integer val = hashtable.get("Second");

        Enumeration<String> str = hashtable.keys(); // Keys
        while (str.hasMoreElements()) {
            System.out.println(str.nextElement());    
        }
        

        Collection<Integer> cl = hashtable.values(); // One way of getting the values
        Integer[] arr = new Integer[hashtable.size()];        
        cl.toArray(arr);

        // This is a very interesting constructor. The second argument tells at the run time when
        // the size of the hashtable should be increased. This number is between zero and one.
        // So for example, 0.75 means increase it when we reach 0.75.
        Hashtable<String, Integer> hash = new Hashtable<String, Integer>(15, 12f); 


    }
}
