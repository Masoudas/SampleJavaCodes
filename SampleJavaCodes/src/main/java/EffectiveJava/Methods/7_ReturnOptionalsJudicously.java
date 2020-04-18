package EffectiveJava.Methods;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Predicate;

/**
 * See below the description for what optionals are.
 * 
 * They are essentially a mid-ground between returning null or raising
 * an exception. Optionals are similar in spirit to checked exceptions
 * 
 * Because they're more expensive than returning the reference, we should be careful
 * when using the instead of those, although because they make
 * the code less error prone they are preferable. But because they are less heavy than exceptions,
 * we may replace exceptions with them. Advantage of exceptions being that they
 * declare why the problem occured.
 * 
 */

/**
 * An optinal is a class that either contains nothing (is empty) or a value.
 * It's essentially something in between returning a null from a method (see
 * item 6 here), or raising an excetion.
 * 
 * Optionals should not return nulls, that would defeat their entire purpose!
 * 
 * Optional is immutable.
 */
class OptionalReturner {
    public static Optional<String> optiOnalWithReferenceType(String name) {
        // This program should have been written in one line, using
        // Optional.ofNullable()
        // but for the sake of illustration.
        if (name == null) {
            return Optional.empty();
        }

        return Optional.of(name);

    }

    /**
     * Because boxing and unboxing is expensive for boxed types, we have have
     * specific implementations for some primitive values.
     */
    public static OptionalInt optionalWithIntType(double val) {
        int intVal = (int) val;
        if (intVal - val != 0) {
            return OptionalInt.empty();
        }

        return OptionalInt.of(intVal);

    }

    /**
     * As mentioned earlier, for empty collections, we must return empty collections
     * and not optionals, nulls or whatever.
     */
    public static Collection<Integer> noOptionalForCollections() {
        return Collections.emptyList();
    }

     // Many of the stream methods such as max, return an Optional by themselves.
     public static  <E extends Comparable<E>> Optional<E> max(Collection<E> c){
        return c.stream().max(Comparator.naturalOrder());
    }

    /**
     * Code to show how to handle optionals.
     */
    public static void main(String[] args) {
        Optional<String> result = optiOnalWithReferenceType("A");

        if (result.isPresent()) {
            System.out.println(result.get());
        }

        // Or we can handle it in a more compact manner.
        Optional<String> result1 = optiOnalWithReferenceType(null);
        System.out.println(result1.orElse("No string was found"));

        // Or we can use orElseGet to pass a predicate. This predicate
        // works on the element to see if it matches a constranint, and then
        // returns the value.
        // result1.orElseGet(pOnString);
    }

   
}

