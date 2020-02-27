package SampleJavaCodes.Basics;

class Casts {
    public void castBetweenBasicTypes() {
        /**
         * Question: Is there need for cast between an array of integers to an array of longs?
         * (because we know that a cast is not needed from integer to long).
         * 
         * The answer is no. This is because an array of integers occupies a certain dimension in
         * the memory. Now, just directly assigning it to an array of longs means that when
         * parsing over the array, we overrun the underlying integer array. Hence, no a cast is not
         * possible. Note also that an actual cast does not cast, for the obvious reason that
         * memory occupation is not the same among the two.
         */
        int[] arr = {1, 2, 3};
        // long[] arr1 = arr; This is impossible.
        // long[] arr1 = (long[])arr;
        
    }

    
}