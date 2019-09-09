/* String buffer classes has four constructores, which accept nothing, an integer, string or a character set.
The main point is that they allocate space for 16 extra characters, which speeds up the job of reallocation.
Why we use it? Because adding strings is a costly operation, because a new location in the memory has to be allocated every time.
*/

/*
StringBuilder is similar to StringBuffer except for one important difference: it is not synchronized, which means that it is not thread-safe. The advantage of
StringBuilder is faster performance. However, in cases in which a mutable
string will be accessed by multiple threads, and no external synchronization is
employed, you must use StringBuffer rather than StringBuilder.
*/

package SampleJavaCodes.StringClass;

class StringBufferExample{
    public static void main(String[] args) {
        StringBuffer str1 = new StringBuffer(); // 16 chars are preallocated by design.
        StringBuffer str = new StringBuffer("Hey");
        
        System.out.println(str.length());   // The length of the string stored.
        System.out.println(str.capacity()); // We see that it is 16 characters more than the length of the string, which is 16 * 2 bytes more, because chars are 2 bytes in Java!


        // If we know in advance the full length of string, we can assign it from the get go.
        StringBuffer str2 = new StringBuffer();  // 16 chars are allocated.
        str2.ensureCapacity(32); // A string of at least 32 chars is ensured. It may be the case that larger buffer is allocated for efficiency reasons.

        System.out.println(str2.capacity());

        // WE may set the length of the string (increase or decrease it). If we increase it, null characters will be set at the end, and length would be the number, and capacity at least the number.
        // If we decrease it, the string will be cut.
        str.setLength(20); // Increasing
        System.out.println(str);    // The output string will be the same
        System.out.println(str.length() + ", " + str.capacity());
        System.out.println("character at 15 is: " + str.charAt(15) + ", which is \0");
        
        str.setLength(2);
        System.out.println(str);
        System.out.println(str.length() + ", " + str.capacity());

        // To put a sub-string of a string inside an array of chars, we use getChars. We can also use substring.
        char[] arr = new char[4];
        str.getChars(0, 1, arr, 2); // Put the first to second char in the second onward of arr.

        String strNormal = str.substring(0, 2);
        System.out.println(strNormal);

        // The append method allows for appending strings to the stringBufferclass. 
        // When calling the method, it not only appends the original string, but also spits out a new StringBuffer class!
        StringBuffer str3 = str.append("y Man!").append(" What's up?");
        System.out.println(str);
        
        System.out.println(str3);

        // To insert a string somewhere in the original string, we may use insert.
        str.insert(4, "Dude");
        System.out.println(str);

        // We may also delete characters.
        str.deleteCharAt(0);
        System.out.println(str);

        str.delete(12, 14);
        System.out.println(str);

        // We may also replace charcter sets too.
        str.replace(0, 2, "Hey");
        System.out.println(str);
    }
}