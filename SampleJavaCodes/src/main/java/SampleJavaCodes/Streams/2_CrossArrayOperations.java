package SampleJavaCodes.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class CrossArrayOperations {
    public static void compareTwoArrays() {
        // We want to see if every is less than it's corresponding
        // in the other array.
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        
        boolean less = true;
        for (int i = 0; i < arr2.length && less; i++) {
            less = arr1[i] < arr2[2];
        }

        Arrays.stream(arr1).allMatch((t)-> t < 2);  // This returns a bool, which is half of what we're looking for

        List<Boolean> lessResult = IntStream.range(0, arr1.length).mapToObj(i -> arr1[i] < arr2[i])
                .collect(Collectors.toList());
        
    }
    
}