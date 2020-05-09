package EffectiveJava.ClassesAndInterfaces;

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

    public static void main(String[] args) {
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE)).filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20).forEach(System.out::println);
    }

    static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }
}