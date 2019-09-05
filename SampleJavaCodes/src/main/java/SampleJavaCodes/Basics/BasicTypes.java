/**
 * BasicTypes
 */
package SampleJavaCodes.Basics;

public class BasicTypes {

    public static void main(String[] args) {
        // There's no unsigned variable in java.
        // Note that every decimal literal is integer by itself.
        byte byte1 = 10; // one byte
        byte byte2 = (byte)0xFA;    // When assigning hexadecimal literals, we need the cast. Well I suppose to indicate we really mean it. Here for example we say
                                    // we want the sign bit to be one, hence this number is interpreted as -6.
        short short1 = -10; // 2 bytes
        int int1 = -100; // 4 bytes (32 bits) (ranging from -2^31-1 to 2^31 ).
        int int2 = 100;
        int int3 = int1 + int2; // No promotion to long here

        long long1 = -100; // 8 bytes.
        
        // Because decimal literals are integers, to define a long literal we need to indicate L.
        long long2 = 0x7FFFFFFFFFFFFFFL;

        // Literals of the form 10.1 are all double precision, and when they are assigned to float, so long as they are in the
        // valid range, no problem happens.
        float float1 = 10.1f;    // To specify floating point, one needs to add at the end
        float float2 = 10.1F;
        float float3 = 1e-2F;   // So l

        double double1 = 1e-20;
        double double2 = 1e-20D;

        char char1 = 20; // Java uses unicode to represent characters, and not ASCII. It is 16 bits, and it cannot be negative.
        char char2 = 'A'; // A double quotation would represent characters  

        // Don't forget that casting is between incompatible types, like double to int.
        // Where type conversion makes sense (like from int to double), it is done with no problem.
        double1 = int1; // Ok
        int1 = (int)double2; // Needs cast.

        // Promotion happens when need to use to variables of different type, or the result of a basic operation
        // ma go beyond the scope of current type. Hence, when adding two floats, result is promoted to double, which then needs 
        // to be cast back to float.
        float1 = (float)(float2 + float3); // If the cast is not written and result is outside of the scope (and don't forget that this
            // is not a literal, hence we cannot directly assign it to a float), we get a run-time error. This is why eventhough we don't get
            // a compile time error, we need to cast it.

        int[] arr = new int[5]; // Upon initialization, all elements in numerical types are set to zero.
        boolean[] arr1 = new boolean[2];    // All variables in boolean are initialized to false.
        String[] str = new String[2];   // For reference types, all initializations are to null.

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
        var variable = "The type will be variable";
        

        // Also note that
        //var arr6 = new int[5];

        // Left and right shifts are interesting.
        // Right shifts are equivalent to devision by two. Hence, when a negative is shifted right, the sign is preserved!
        byte b = -8; // 0b11111000
        b = (byte)(b >> 1); //  0b11111100, which is equivalent to -4

        b = (byte)0x8F; 
        b = (byte)(b >>> 1);    // This form of shift actually shifts the bytes around. However for negative numbers, because of integer promotion, this would
                          // pointless and equivalent to the normal >>.
                          // Anyways, this shifting is the same as >>>, unless we have an integer.

        byte b1 = -8;
        b1 = (byte) (b1 << 1); // The behavior is complicated. First we promote to int, then when shifting, the sign bit is extended. Then after,
                             // we need to cast back to byte. The same story goes for short. 

        int i = 0xFFFFFE; // Note that with left shifts, the 1 bit will actually fall inside the sign bit.
        i = i << 4; // We will get a negative value.

        // The ternary if (?:) only works if the return types are the same, or compatible. Also note that in the following case, the return type is considered int 
        // Because the return type is derived from the left expression.
        double val1 = false ? 0 : 1/5;   // In this case, it will be zero for both cases.        

        // This type of inference does not work either
        // var val = false ? 0 : 1/5;   // In this case, it will be zero for both cases.

        // As in C++, [], () and dot operators have the highest priority. FYI this is why we use paranthesis to give priority.

        // Foreach array
        int[] arr5 = {1, 2, 3, 4};
        for (int var : arr5) {
            // Unlike C++, we cannot access the actual content of the array.
            System.out.println(var);
        }

        // Foreach also works for multiD arrays.
        int[][] arr6 = {{1, 2}, {3, 4}};
        for (int[] var : arr6) {
            for (int var1 : var) {
                System.out.println(var1);
            }
            
        }

    }
}