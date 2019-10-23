/**
 * The Arrays class provides several methods for working with arrays.
 */

package SampleJavaCodes.UtilLibrary;

import java.util.Arrays;

class ArraysClassExample{
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 5};

        Arrays.sort(arr);

        for (int var : arr) {
            System.out.println(var);    
        }
        
        int[] arr2 = Arrays.copyOf(arr, arr.length); // This would be a copy of the thing.

        A[] arr3 = {new A(), new A()};

        A[] arr4 = Arrays.copyOf(arr3, arr3.length); // Of course this would be
                                    // a shallow copy of the elements. The entire array would 
                                    // be copied a new, but the reference values would be the same.

        arr4[0].x = 1;
        System.out.println("This value would be 1 as expected: " + arr4[0].x);

        
        // Checking if two arrays are equal.
        System.out.println("The two arrays are equal: " + Arrays.equals(arr, arr2));

        // Initialize an entire array to a particlar value.
        int[] arr5 = new int[3];
        Arrays.fill(arr5, 2);

        // Parallel sorting can do sorting in parallel.
        Arrays.parallelSort(arr);

    }
}

class A{
    public int x = 20;
}