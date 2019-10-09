/**
 * There are two keywords:
 * Transient:
 * When an instance variable is declared as transient, its value need not persist 
 * when an object is stored.
 */

package SampleJavaCodes.Classes;


 class T{
     transient int a = 10;  // This transient value would not be stored in the persistent
                            // memory. In other words if an object of type T is written to 
                            // a persistent storage area, the contents of a would not be saved, 
                            // but the contents of b would
     int b = 20;
 }


/**
 * Volatile variables are like C++, means they are subject to change.
 * For example, if a variable is synchronised, we copy it in several other
 * threads, but we declare them volatile to tell the compiler that their
 * content might change.
 */