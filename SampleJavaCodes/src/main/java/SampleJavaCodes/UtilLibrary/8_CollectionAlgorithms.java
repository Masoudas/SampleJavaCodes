/**
 * When working with collections, we need to apply different algorithms to a 
 * particular collection (like sorting, copy and so forth). 
 * These are defined in the Collections class.
 */

package SampleJavaCodes.UtilLibrary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

class CollectionAlgorithmsExample {
    public static void main(String[] args) {
        ArrayList<Float> arr = new ArrayList<Float>(5);
        arr.add(5.0f);
        arr.add(51.0f);
        arr.add(15.0f);
        arr.add(195.0f);
        arr.add(1.0f);
        arr.trimToSize();

        System.out.println(arr);

        // Shuffle
        Collections.shuffle(arr);
        System.out.println(arr);

        // To copy two arrays, we better use the constructor form. Note that this
        // is a shallow copy.
        ArrayList<Float> arr1 = new ArrayList<Float>(arr); 
        System.out.println(arr1);

        // Just to prove that this is a shallow copy.
        arr1.set(0, 33123123.1f);
        System.out.println(arr1);

        // Sort the collection.
        Collections.sort(arr1);

        // This is very interesting. Returns a copy of the collection that is only
        // readable.
        // There's an unmodifiable version for everything.
        List<Float> arr2 = Collections.unmodifiableList(arr);
        try {
            arr2.add(17.1f);
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Was unable to add a value to an unmodfiable list. " );
        }

        // This is interesting, returns an immutable version of the collection!
        Set<ArrayList<Float>> ts = Collections.singleton(arr1);

        // To get a synchronized version of a collection, we can use the Collections class
        // as well.
        Collection<Float> arr3 = Collections.synchronizedCollection(arr1); // Wel/


        
    }
}

