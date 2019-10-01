/**
 * The rules for regex are (see also https://www.rexegg.com/regex-quantifiers.html):
 * 
 * 
 * []: Defines a character set (just one char). For example, [xyz], means must match these.
 * Note again that a char set is just one char. For example, [x+] does not mean one or
 * more x, means x and + sign!
 * (): A character set, meaning one char or more.
 * [^]: Means the negate of this char set.
 * ^(): Means the negate of this group
 * [x-y]: Means the range between x and y, for example 3-10 or a-c.
 * {min,max}: Allows to directly specify how many chars we need. For example A{2,9} means between
 * two to nine As.
 * {min}: Specify min times
 * {min,}: Specify min times, but possibly more.
 * 
 * 
 * .: Means any char or digit.
 * +: Means one or more char. It also means reluctant algorithm as opposed to greedy.
 * *: Means zero or more char.
 * ?: Means zero or one. It also means possesive behavior
 * 
 * \w: chars (not digit or special chars like \n)
 * \d: Supposed to be digit.
 * 
 * 
 * We need to specify behaviors:
 * Greedy: Means as many as we can. For example \d+ means as many digits. Hence, in 1234
 * we do not return 1, 2, 3, 4, but just 1234. But we are also docile, as this example
 * shows:
 * Example: Consider AAA. What we call greedy is actually greedy-docile.
 * (A+): The entire pattern AAA is matched. No give back of chars happen.
 * (A+).: The A+ part matches the AA part. In other words, A+ gives back one A.
 * (A+)..: The A+ part matches the A part. In other words, A+ gives back A++
 
 * Reluctant or lazy:  Meaning match as few a chars as possible. As stared earlier, this is done
 * using ?. The extended example below is the perfect example. Note that reluctancy applies
 * to the shortest match found inside of a string, but there may be substrings that still match
 * the behavior (For example in "extendeded end", if we search for e.+d with a greedy algorithm we
 * return extendeded end, with reluctant, extendeded (and not ed), and with possessive, 
 * we return nothing!)
 * 
 * Possesive: This is a bit more complicated. So, in the greedy algorithm,
 * we may give back chars in order to match. Consider the following example:
 * 
 * Example: Consider AAA. What we call greedy is actually greedy-docile.
 * (A+): The entire pattern AAA is matched. No give back of chars happen.
 * (A+).: The A+ part matches the AA part. In other words, A+ gives back one A.
 * (A+)..: The A+ part matches the A part. In other words, A+ gives back A++
 * 
 * We see that A+ gives back chars. Now consider A++. pattern. In this scenario, we possess
 * as many chars as possible and never return anything. So surprisingly,
 * AAA is not matched at all.
 * 
 
 */

// In the following example, we try and find patterns with regulars.

package SampleJavaCodes.StringClass.Regex;

import java.util.regex.*;

class MatchingWithRegular{
    public static void main(String[] args) {
        // As we know, dot means any character. The bracket checks for the set we define. ^ means complement
        Pattern pat = Pattern.compile("Java.[xyz]");
        System.out.println("Pattern exists in Java x: " + pat.matcher("Java x").matches());
        System.out.println("Pattern exists in Java_y: " + pat.matcher("Java_y").matches());
        System.out.println("Pattern exists in Java a: " + pat.matcher("Java a").matches());

        // With the complement set
        System.out.println("With the complement set");
        pat = Pattern.compile("Java.[^xyz]");
        System.out.println("Pattern exists in Java x: " + pat.matcher("Java x").matches());
        System.out.println("Pattern exists in Java_y: " + pat.matcher("Java_y").matches());
        System.out.println("Pattern exists in Java a: " + pat.matcher("Java a").matches());

        // One character or more with +
        System.out.println("One character or more");
        pat = Pattern.compile("Java.([^xyz]+)");
        System.out.println("Pattern exists in Java x: " + pat.matcher("Java x").matches());
        System.out.println("Pattern exists in Java_y: " + pat.matcher("Java_y").matches());
        System.out.println("Pattern exists in Java : " + pat.matcher("Java ").matches());
        System.out.println("Pattern exists in Java a: " + pat.matcher("Java a").matches());
        System.out.println("Pattern exists in Java aa: " + pat.matcher("Java aa").matches());

        // Zero character or more with *
        System.out.println("Zero character or more");
        pat = Pattern.compile("Java.([^xyz]*)");
        System.out.println("Pattern exists in Java x: " + pat.matcher("Java x").matches());
        System.out.println("Pattern exists in Java_y: " + pat.matcher("Java_y").matches());
        System.out.println("Pattern exists in Java : " + pat.matcher("Java ").matches());
        System.out.println("Pattern exists in Java a: " + pat.matcher("Java a").matches());
        System.out.println("Pattern exists in Java aa: " + pat.matcher("Java aa").matches());

        // Zero or one character with ?
        System.out.println("Zero character or one");
        pat = Pattern.compile("Java.([^xyz]?)");
        System.out.println("Pattern exists in Java x: " + pat.matcher("Java x").matches());
        System.out.println("Pattern exists in Java_y: " + pat.matcher("Java_y").matches());
        System.out.println("Pattern exists in Java : " + pat.matcher("Java ").matches());
        System.out.println("Pattern exists in Java a: " + pat.matcher("Java a").matches());
        System.out.println("Pattern exists in Java aa: " + pat.matcher("Java aa").matches());

        // Some nice and simple examples:
        System.out.println("Any char set that starts with e and ends with d.");
        pat = Pattern.compile("e.+d"); // Any char set that starts with e and ends with d.        
        System.out.println("The result in string \" extend cup end table\" would be:");
        

        Matcher mat = pat.matcher("extend cup end table");
        while(mat.find()){
            System.out.println(mat.group());
        }

        // The output result will be extend cup end, and not extend and then end.
        // This is due the greedy behavior of the matching. To specify reluctant 
        // behavior, we may use the ? (after the + sign)! 
        System.out.println("Reluctant behavior");
        pat = Pattern.compile("e.+?d"); // Any char set that starts with e and ends with d.        
                                        
        mat = pat.matcher("ede121_-2ded extend cup end table");
        while(mat.find()){
            System.out.println(mat.group());
        }
        

        // Example of a possessive behavior.
        System.out.println("Possesive behavior");
        pat = Pattern.compile("e.++d"); // Any char set that starts with e and ends with d.        
                                        
        // In this example, no match will be found, because the possessive behavior
        // does not allow the d at the end to be given the opportunity to be found!
        mat = pat.matcher("ede121_-2ded extend cup end table");
        while(mat.find()){
            System.out.println(mat.group());
        }
 

        pat = Pattern.compile("[1-9]*E");
        System.out.println(
            "Pattern exists in 123EEE: " + pat.matcher("123E").find());
        
        mat = pat.matcher("123EE");        
      
        while(mat.find()){
            System.out.println(mat.group());
        }

        // Example: We are looking for patterns like Proj_t0_c0_z0. 
        // Hence, we seek something like Proj_t(\d+)_c(\d+)_z(\d+)
        System.out.println("Pattern like Proj_tdxxx_cxxx_zxxx");
        //pat = Pattern.compile("Proj_t(\d+)_c(\d+)_z(\d+)");
        pat = Pattern.compile("Proj_t([0-9]+)_c([0-9]+)_z([0-9]+)");
        System.out.println(
            "Pattern exists in Proj_t0_c9_z9: " + pat.matcher("Proj_t0_c9_z9").matches());
        System.out.println(
            "Pattern exists in Proj_t100_c001_z9: " + pat.matcher("Proj_t100_c001_z9").matches());
        pat = Pattern.compile("Proj_t([0-9]+)_c([0-9]+)_z([0-9]+)");
        System.out.println(
            "Pattern exists in Proj_t0_c9_z9: " + pat.matcher("Proj_t0_c9_z9").matches());                
    }
}
