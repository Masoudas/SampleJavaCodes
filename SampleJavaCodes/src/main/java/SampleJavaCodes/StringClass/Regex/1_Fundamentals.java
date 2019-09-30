/**
 * The java.util.regex package supports regular expression processing. 
 * Beginning with JDK 9, java.util.regex is in the java.base module
 * 
 * There are two classes that support regular expression processing: Pattern 
 * and Matcher. These classes work together. Use Pattern to define a regular 
 * expression. Match the pattern against another sequence using Matcher.
 * 
 *  
 * 
*/ 

package SampleJavaCodes.StringClass.Regex;

import java.util.regex.*;

/**
 * The Pattern class defines no constructors. Instead, a pattern is created by
 * calling the compile( ) factory method.
 * 
 * 
 */

class PatternExample{
    public static void main(String[] args) {
        Pattern pat; 
        Matcher match;

        pat = Pattern.compile("Java");
        match = pat.matcher("Java");    // The matcher method is inside of this.

        Boolean matches = match.matches(); // The matches method checks whether the two expressions completely match.
        System.out.println("The two string match: " + matches);

        try{
            int start = match.start();  // Return the start index of the match.
            int end = match.end(); // The index that is returned by this method is one past the end!
                                   // If no match exists, then an IllegalStateException is returned.

                                   // These two methods only work for partial match.
            System.out.println("Start is: " + start + " and end is: " + end);    
        }
        catch (IllegalStateException e){
            System.out.println("An exception was caught!");
        }

        // Now we go to partial matching, where we check for 
        match = pat.matcher("Java Java avaJ");    // The matcher method is inside of this. Each time this method is called, 
                                                 // the method starts from where it left off.

        for (int i = 0; i < 14-4; i++) {
            matches = match.find(); // The find method matches whether the search pattern exists inside of the string.
                                    // This match will return false, 
            
            
            System.out.println("The two string partially match: " + matches);    
            if (matches){
                String matchedStr = match.group();  // This method returns the string that has matched the pattern,
                                                    // Understand that this good for when there's a pattern present,
                                                    // Not in this simple case.
                System.out.println("The matched string would be: " + matchedStr);            
            }
        }
        

        // Finally, we can replace all occurances of a string with a desired string.
        String replacedStr = match.replaceAll("Yo, this is Java.");
        System.out.println(replacedStr);

    }
}

