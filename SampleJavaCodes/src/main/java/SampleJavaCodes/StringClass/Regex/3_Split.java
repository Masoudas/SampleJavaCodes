/**
 * It's possible to break a regular expression into substrings
 * using the split method and pattern class.
 * 
 * 
 * 
 */

package SampleJavaCodes.StringClass.Regex;

import java.util.regex.*;

class Splitter{
     public static void main(String[] args) {
        // In this example, we try and split on the following chars.
        // After splitting, the plitter char does not remain there!
        Pattern pat = Pattern.compile("[!,.+]");         
        String str[] = pat.split("qwerty: I'm not that! You are. Get out + me.");

        for (String var : str) {
            System.out.println(var);
        }

     }
 }