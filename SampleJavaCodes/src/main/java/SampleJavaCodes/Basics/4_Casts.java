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

    public void castFromDoubleToInteger() {
        /**
         * What happens when we cast from double or float to integer?
         * This is tricky, because double and float are scientifc presentations,
         * as opposed to numeric types.
         * 
         * Normally, we except in range values to be transformed properly.
         * For the outside values however, the results are random.
         * 
         * Question is, would the lack of precision in double and float in representing
         * numbers cause any problem in this cast? The answer is no.
         */
        System.out.println((int)17.3d); // The result would be 17.
        System.out.println((int)Math.pow(2, 17)); // The result would be a random number, because out of range.

        // Finaly, note that the double class has a intValue().
        Double double1 = 165.434234;
        System.out.println(double1.intValue());
        
    }

    
}