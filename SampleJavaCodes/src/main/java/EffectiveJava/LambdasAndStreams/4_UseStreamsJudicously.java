package EffectiveJava.LambdasAndStreams;

import java.math.BigInteger;
import java.util.stream.Stream;

class PrinitingFirst20MersennePrimes {
    /**
     * A Mersenne prime number is of form 2^p - 1, where p is prime and so is 2^p -
     * 1. We call 2^p - 1 a Mersenne prime.
     * 
     * So we want to write a program that prints the first 20 Mersennes. To do so,
     * we need to get as many prime numbers as possible, calculate 2^p - 1, and see
     * if the result is prime.
     * 
     * First, note the Stream.iterate which is amazing. It starts with a seed and
     * every time a next is called, it returns f^n(seed), where n = 0, 1, ... . And
     * this is an infinite stream!
     * 
     * 
     * Next, BigInteger::nextProbablePrime returns the next probabale prime that is
     * greater than the integer fed to it!
     * 
     * The pow function of course maps this to the power.
     * 
     * The BigInteger.isProbablePrime checks whether the given BigInteger is a prime
     * or not.
     * 
     * @param args
     */

    public static void main(String[] args) {
        primes().map(p -> BigInteger.valueOf(2).pow(p.intValueExact()).subtract(BigInteger.ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50)).limit(20).forEach(System.out::println);
    }

    static Stream<BigInteger> primes() {
        return Stream.iterate(BigInteger.valueOf(2), BigInteger::nextProbablePrime);
    }

}

/**
 * Print Mersenne power before the result.
 * For that, we can create an object that has the prime together with the value.
 * And then print it. Or Because integer is still present in the first Stream,
 * we can print it there directly.
 */
class PrinitingFirst20MersennePrimesWithPowers {
    
    public static void main(String[] args) {
        primes().map(t -> BigInteger.valueOf(2).pow(t.intValueExact()).subtract(BigInteger.ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50)).limit(20).forEach(System.out::println);
    }

    static Stream<BigInteger> primes() {
        // return Stream.iterate(new Moresenne(), (t)->{t.p = t.p.nextProbablePrime(); return t;});
        return Stream.iterate(BigInteger.valueOf(2), BigInteger::nextProbablePrime);
    }

}