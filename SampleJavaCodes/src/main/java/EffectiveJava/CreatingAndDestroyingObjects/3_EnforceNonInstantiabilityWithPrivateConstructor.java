package EffectiveJava.CreatingAndDestroyingObjects;

/**
 * To make a (static) class non-instantiable, make sure the constructor is
 * private.
 * 
 * Note that making a class abstract is not the same (who does that?).
 * Especially because it implies that we want the class to be inherited.
 * Defining constructors private is as we one, one powerful way to stop
 * inheritance.
 */

class StaticMethods {
    private StaticMethods() {
        throw new AssertionError(); // To avoid invokation with reflection, or accidentaly invoking it from
        // inside the class.
    }
}