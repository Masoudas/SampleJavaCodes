// The purpose of this file is to check access to another file.

package TestPackage;

/**
 * checkAccessToOtherPackage
 */
import SampleJavaCodes.Basics.*;

public class checkAccessToOtherPackage {
    // For example, here we have access to Example1 class, but not Example11.
    SampleJavaCodes.Basics.Example1 example1 = new SampleJavaCodes.Basics.Example1();
    Example1 example2 = new Example1();

    
}