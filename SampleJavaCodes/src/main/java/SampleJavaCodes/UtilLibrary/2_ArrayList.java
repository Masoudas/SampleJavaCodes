/**
 * The ArrayList class extends AbstractList and implements the List interface.
 * It implements arrays that can grow in size, as opposed to the normal arrays
 * that have a predefined size.
 * 
 * 
 */

package SampleJavaCodes.UtilLibrary;

import java.util.ArrayList;
import java.util.ListIterator;

class ArrayListExample{
     public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<Integer>(10); // This constructor accepts the minimal size.
        arrList.ensureCapacity(30);    // Ensuring the minimum capacity.
        
        boolean added = arrList.add(10);    // Adding elements
        arrList.add(20);
        arrList.add(0, 5);  // Add to the zero-th element.
        arrList.trimToSize();   // Trim the size of the array to the number of elements it currently holds.

        System.out.println(arrList);    // The default toString() of this class is called.

        Object[] arr = arrList.toArray(); // Returning an array of objects;
        Integer[] arr1 = new Integer[arrList.size()];
        Integer[] arr2;
        arr2 = arrList.toArray(arr1);   // If size of arr1 is less than required, arr2 would be filled with the proper size.
        System.out.println(arr1[0] + " " +  arr1[1] + " " + arr1[2]);  
                

        ArrayList<Integer> arrList1 = new ArrayList<Integer>(arrList); // This constructor initializes from
        // other array.
        
        // We can iterate over the list, because of the implementation 
        // the iterable interface. What happens here is that we just get
        // the iterator object of the list. 
        for (Integer integer : arrList1) {
            System.out.println(integer);  
        }

        // As we know, the list iterator actually gets a reference 
        // to the underlying object.
        ListIterator<Integer> lIterator = arrList1.listIterator();
        

        
     }
 }