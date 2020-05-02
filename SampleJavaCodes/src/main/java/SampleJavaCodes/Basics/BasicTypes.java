/**
 * BasicTypes
 */
package SampleJavaCodes.Basics;

import java.util.Arrays;

public class BasicTypes {
    int b = 20;
    Example11 example11 = new Example11(); // We see that Example11 class eventhough private, can be accessed in the
                                           // same (sub)package.

    public static void main(String[] args) {
        // new BasicTypes().multiDimArrays();
        BasicTypes bTypes = new BasicTypes();
        // bTypes.arrayManipulation();
        bTypes.cloningArrays();
        // bTypes.assignmentToVariables();
        // There's no unsigned variable in java.
        // Note that every decimal literal is integer by itself.
        
        byte byte1 = 10; // one byte
        short short1 = -10; // 2 bytes

        // short short2 = 0xffff; // This definition is not ok, because the range is outside the scope of short, and we must have a cast.
        short short2 = (short)0xffff; // This assignment would be taken literally now, meaning that the value would be set to -1.
                                      // That's the whole point of casting with hexadecimal.
        short short3 = 0xfff; // So this would be ok. Because the range proposed by the hexadecimal is within the range.
                              // which is 2^12-1.
        

        // Promotion rules:
        // Byte, short and char are promoted to int during assignments.
        // So they need a cast back to their types
        byte byte2 = (byte) (byte1 * 2);    

        // Int is 32 bits of course. and summation or other arithmetic has no promotion.
        int int1 = -100; // 4 bytes (32 bits) (ranging from 2^31-1 to -2^31 ).
        int int2 = 100;
        int int3 = 0xffffffff - 1 + int2;


        long long1 = -100; // 8 bytes.

        // Because decimal literals are integers, to define a long literal we need to
        // indicate L.
        long long2 = 0x7FFFFFFFFFFFFFFL;

        // Literals of the form 10.1 are all double precision, and when they are
        // assigned to float, so long as they are in the
        // valid range, no problem happens.
        float float1 = 10.1f; // To specify floating point, one needs to add at the end
        float float2 = 10.1F;
        float float3 = 1e-2F; // So l

        double double1 = 1e-20;
        double double2 = 1e-20D;

        char char1 = 20; // Java uses unicode to represent characters, and not ASCII. It is 16 bits, and
                         // it cannot be negative.
        char char2 = 'A'; // A double quotation would represent characters

        // Don't forget that casting is between incompatible types, like double to int.
        // Where type conversion makes sense (like from int to double), it is done with
        // no problem.
        double1 = int1; // Ok
        int1 = (int) double2; // Needs cast.

        // Promotion happens when need to use two variables of different type, or the
        // result of a basic operation
        // ma go beyond the scope of current type. Hence, when adding two floats, result
        // is promoted to double, which then needs
        // to be cast back to float.
        float1 = (float) (float2 + float3); // If the cast is not written and result is outside of the scope (and don't
                                            // forget that this
        // is not a literal, hence we cannot directly assign it to a float), we get a
        // run-time error. This is why eventhough we don't get
        // a compile time error, we need to cast it.

        // See also morePromotion method below!

        int[] arr = new int[5]; // Upon initialization, all elements in numerical types are set to zero.
        boolean[] arr1 = new boolean[2]; // All variables in boolean are initialized to false.
        String[] str = new String[2]; // For reference types, all initializations are to null.

        // What is the difference between the following two notations? Equivalent.
        int arr2[] = new int[4];
        int[] arr3 = new int[5];

        // Jagged arrays: We don't need to specify the second dimension.
        // This is like decaling an array of pointers in c++.
        int arr4[][] = new int[3][];
        arr4[0] = new int[1];
        arr4[1] = new int[2];
        arr4[2] = new int[3];

        // The following type inferences will start from JDK 10.
        // var variable = "The type will be variable";

        // Also note that
        // var arr6 = new int[5];

        // Left and right shifts are interesting.
        // Right shifts are equivalent to devision by two. Hence, when a negative is
        // shifted right, the sign is preserved!
        byte b = -8; // 0b11111000
        b = (byte) (b >> 1); // 0b11111100, which is equivalent to -4

        b = (byte) 0x8F;
        b = (byte) (b >>> 1); // This form of shift actually shifts the bytes around. However for negative
                              // numbers, because of integer promotion, this would
        // pointless and equivalent to the normal >>.
        // Anyways, this shifting is the same as >>>, unless we have an integer.

        byte b1 = -8;
        b1 = (byte) (b1 << 1); // The behavior is complicated. First we promote to int, then when shifting, the
                               // sign bit is extended. Then after,
                               // we need to cast back to byte. The same story goes for short.

        int i = 0xFFFFFE; // Note that with left shifts, the 1 bit will actually fall inside the sign bit.
        i = i << 4; // We will get a negative value.

        // The ternary if (?:) only works if the return types are the same, or
        // compatible. Also note that in the following case, the return type is
        // considered int
        // Because the return type is derived from the left expression.
        double val1 = false ? 0 : 1 / 5; // In this case, it will be zero for both cases.

        // This type of inference does not work either
        // var val = false ? 0 : 1/5; // In this case, it will be zero for both cases.

        // As in C++, [], () and dot operators have the highest priority. FYI this is
        // why we use paranthesis to give priority.

        // Foreach array
        int[] arr5 = { 1, 2, 3, 4 };
        for (int var : arr5) {
            // Unlike C++, we cannot access the actual content of the array.
            System.out.println(var);
        }

        // Foreach also works for multiD arrays.
        int[][] arr6 = { { 1, 2 }, { 3, 4 } };
        for (int[] var : arr6) {
            for (int var1 : var) {
                System.out.println(var1);
            }

        }

        Integer arr7[] = { null, 1 }; // This is interesting!

    }

    public void morePromotionLaws() {
        /**
         * Would there be a difference between the results of this expressions?
         */
        System.out.println(1.2d * (1/2));
        System.out.println(1.2d * 1/2);

        /**
         * In the first one, the content of the paranthesis is integer, so the out come is integer, and result is zero.
         * The second one, promotion happens, so the result would be 0.6!
         */

    }

    public void arrayManipulation() {
        // By default, arrays have zero inside, because an integer is by default zero.
        int[] emptyArry = new int[2];
        System.out.println(emptyArry[0] + " " + emptyArry[1]);   // This line throws a null excpetion.

        // There are several ways to initialize an array. Consider this
        int[] arr = new int[10];
        Arrays.fill(arr, 20); // Well this is one method to initialize all to a particular value.

        // Copying two arrays.
        int[] cpyarr = new int[6];
        cpyarr = Arrays.copyOfRange(arr, 4, 10);
        for (int var : cpyarr) {
            System.out.println(var);

        }

        // We can also use System.arraycopy method
        int[] cpyarr2 = new int[2];
        System.arraycopy(arr, 0, cpyarr2, 5, 2);

        // The clone method is also there
        arr.clone(); // This will use the clone method of every subclass

        // Note that when copying an array of string, because the strings are immutable,
        // a change in either the original
        // or copied array does not affect the other.

        // Is it possible to define array size in the run-time?
        int x = (int) Math.sqrt(9);
        int[] arr2 = new int[x];

        arr2[0] = 10;
        arr2[1] = 20;
        arr2[2] = 30;

        System.out.println(arr2[2] + "\t" + arr2[1] + "\t" + arr2[0]);

        // Note that it is possible to create zero length array
        int[] arrZeroSize = new int[0];

        System.out.println("A zero size array is created here " + arrZeroSize.length);
    }

    public void cloningArrays() {
        /**
         * For cloning arrays, we can use the clone method of the array.
         * For primitive types, it will return a complete copy of the object.
         * For reference types, it will return a copy of the array reference,
         * but not the objects. BE CAREFUL.
         *  */        
        int[] arr = {1, 2};
        int[] arr1 = arr.clone();
        arr1[0] = 3;

        System.out.println("Cloned primitive array " + arr1[0] + " is note the same as original " + arr[0]);

        // We can also copyOf for more control over copying.
        Arrays.copyOf(arr, 2);

    }

    public void assignmentToVariables() {
        /**
         * So when assigning variables, we should be very careful. Note that when we sau
         * a = b, we are not saying a referes to the same memory locations as b, we just
         * copy the address value from b to a. So now, it is completely normal that when
         * we say b = c, a would still refer to b!
         */

        Integer int1 = new Integer(10);
        Integer int2 = int1;
        System.out.println(int1 == int2); // The objects have the same reference.
        int1 = 30; // Boxing is then equal to new Integer(30)
                   // After assignment they are different!
        System.out.println("After boxing the result is not the same: :" + String.valueOf(int1 == int2));

        // But normally, when an assignment happens, the variables refer to the same
        // object.
        BasicTypes b1 = new BasicTypes();
        BasicTypes b2 = b1;

        System.out.println("Both Basics are the same: ");
        System.out.println(b1 == b2); // The objects have the same reference.

        // Of course note that after this assignment, both objects are still the same
        b1 = new BasicTypes();
        System.out.println("After assignment to the old one they are not the same: ");
        System.out.println(b1 == b2); // The objects have the same reference.

    }

    public void passingArrays(int[] arr1) {
        /**
         * It is impossible to pass an array with specific length in java. This is
         * because in the defintion "DATA_TYPE[] ref;", ref is a reference to an array
         * of objects, which clearly does not hold the length option. Hence, it is not
         * reasonable to define DATA_TYPE[5] when defining a function. Specially note
         * that when we define an array of integers for example, we say int[] arr = new
         * int[5], and we indicate the size only in the second part. The first part is
         * the reference holder!
         */

    }

    public void multiDimArrays() {
        /**
         * Multidimensional Arrays can be defined in simple words as array of arrays.
         * Data in multidimensional arrays are stored in tabular form.
         * To keep the fact that the first bracket is column, every new dimension is added
         * BEHIND the first bracket. Hence we have [column], [row][column], [3rd][row][column]
         * and so forth
         * 
         * */
        
        int column = 3;
        int row = 1;
        int thrid = 1;

        double[] x1 = {1, 2, 3, 4};
        double[][] x2 = {{1, 2, 3, 4}, {5, 6, 7, 8}};
        double[][][] x3 = {{{1, 2, 3, 4}, {5, 6, 7, 8}}, {{9, 10, 11, 12 }, {13, 14, 15, 16}}};
    
        System.out.println(x1[column]); // would be 4
        System.out.println(x2[row][column]); // would be 8
        System.out.println(x3[thrid][row][column]); // would be 16

        // When checking the size of n-d arrays, .length property returns the length of 
        // last (leftmost) dimension. Hence, for x3.length we get the third dimension.
        // However, we can say x3[0].length to get the second dimension.

        // This assingment is possible, and would be reference to that part of the original
        // array.
        double[][] x4 = x3[0];
    
    }
}

abstract class A {
    public A() {

    }
}