package EffectiveJava.Methods;

import java.util.Objects;

/**
 * Essentially, we need to check the validity of function arguments.
 * 
 * AN IMPORTANT NOTE: As it turns out, when writing a try catch block, the
 * try statement is relatively costless. The only costly operation is the
 * catch block, which if invoked is costly. See SampleJavaCodes.Exception
 * on how to avoid acquiring stack trace to ease up exception throwing.
 * 
 * 1- Constructors and public methods: we need to check public methods and
 * constructors for validity, and throw exceptions when necessary. This includes
 * checking for null too. To check for null direclt, we can use Objects.requireNonNull().
 * 
 * 2- Private methods: For private methods, we can use Assert to ensure being in range.
 * The asserts are of course debugging checks, and when running the code, they don't come
 * to place.
 * NOTE: In vscode, assertions will appear in unit test. If you want to add them to Run|Debug,
 * you should add it to launch options, only for a particular file!
 * 
 */


 class CheckArgumentsForValidity {
    public static void throwException(Integer integer, int value) {
        Objects.requireNonNull(integer);

        if (value < 0){
            throw new IndexOutOfBoundsException();
        }
    }
    
    private static void assertWithAssert(int value, Integer integer) {
        assert value > 0 : "Wrong range";
        assert integer != null : "Null given"; 
        
    }

    public static void callAssertMethod(int value, Integer integer) {
        assertWithAssert(value, integer);
    }

    public static void main(String[] args) {
        assertWithAssert(0, null);  // Only works in debug mode
    }
 }