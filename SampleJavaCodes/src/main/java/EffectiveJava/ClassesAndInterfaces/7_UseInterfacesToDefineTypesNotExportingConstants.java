package EffectiveJava.ClassesAndInterfaces;

import java.util.stream.Stream;

/**
 * Don't use interfaces to define constants. I mean who does this! Use Utility
 * classes instead. Also notice the use of underscores in defining the
 * constants.
 * 
 * Note finally that we can use import static to import the static fields of the
 * class directly, and then use them without class qualifier.
 * 
 * import static PhysicalConstants;
 */

class PhysicalConstants {
    // Prevents instantiation
    private PhysicalConstants() {
    }

    public static final double AVOGADROS_NUMBER = 6.022_140_857e23;
    public static final double BOLTZMANN_CONST = 1.380_648_52e-23;
    public static final double ELECTRON_MASS = 9.109_383_56e-31;

}