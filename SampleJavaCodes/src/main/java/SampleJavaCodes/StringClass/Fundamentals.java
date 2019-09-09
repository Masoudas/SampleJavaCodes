/* String class as we know is immutable.
 This implies that if we assign an string to another variable and then change the original, the second would still refer to the old string.*/

/* The last character of a string is not \0! */

// We tend to use string builder class rather than the normal string class.
package SampleJavaCodes.StringClass;

import java.lang.String;

public class Fundamentals{
    public static void main(String[] args) {
        String str1 = "Will it remain?";
        String str2 = str1;

        str1 = "Will it?";

        System.out.println(str2);   // You see that the string does remain in the memory after this assignment, so be careful.
        System.out.println(str1.length());
        
    }
}