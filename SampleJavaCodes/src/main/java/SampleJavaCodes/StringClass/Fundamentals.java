/* String class as we know is immutable.
 This implies that if we assign an string to another variable and then change the original, the second would still refer to the old string.*/

/* The last character of a string is not \0! */

// We tend to use string builder class rather than the normal string class.
package SampleJavaCodes.StringClass;

import java.lang.String;

public class Fundamentals{
    public static void main(String[] args) {
        String str11 = "Will it remain?";
        String str21 = str11;

        str11 = "Will it?";

        System.out.println(str21);   // You see that the string does remain in the memory after this assignment, so be careful.
                                    // And as we discussed in the basics, this is a normal function of the Java.
        System.out.println(str11.length());

        // This assignment makes a completely new copy of the object.
        String str1 = new String("Hey");
        String str2 = str1; // copies separately.
        String str3 = new String("Hey");

        System.out.println(str1 == str2);   // The objects have the same reference.
        System.out.println(str1 == str3);   // The objects have the same reference.
        str1 = str3;  // New memory
        System.out.println(str1 == str2);   // After assignment they are different!
        System.out.println("But content of the string is the same: " + str1.equals(str2));   // After assignment they are different!                
        
        
        // Here's something very fundamental though, apprently when we say String str1 = "Hey", we do
        // what is called string interning. It means that JVM only creates one instance of an string
        // per life time. Hence, we get true in the following == equation.

        String str31 = "Hey";
        String str32 = "Hey";

        System.out.println(str31 == str32); // The comparison is like a primitive type (only the content is compared)
                                            // hence, we get True! We don't compare the reference here.
        
    }
}