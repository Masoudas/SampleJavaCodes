/**
 * It is possible to just import the static methods of a package.
 * For this end, we use the static keyword with the import.
 * It only imports the static methods of the class. So we don't
 * actually import the class.
 * It is also possible to import all static methods of a class.
 * 
 * 
 */

import static java.lang.Math.sqrt; // Note that this is a method, and not a class.
import static java.lang.Math.*; // All static methods of this class are imported.
import java.lang.Math;  // Normal import of the class.

class StaticImportExample{
    public static void main(String[] args) {
        System.out.println(sqrt(5));


        System.out.println(Math.sqrt(5));
    }
}

