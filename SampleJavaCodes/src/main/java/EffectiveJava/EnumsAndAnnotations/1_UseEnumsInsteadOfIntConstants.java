package EffectiveJava.EnumsAndAnnotations;

import java.util.EnumSet;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * enums and Annotations are two special types. an enum type is a type whose
 * legal values consist set of constant literals. We call the values of a enum
 * its constants.
 * 
 * The problem with int literals is that, they can't be checked propely (and
 * that's why we use enum type in the first place).
 * 
 * enums are classes in and of themselves (hence they have constructors).
 * Because their constructors cannot be public, they implement the singleton
 * pattern, and each enumeration constant is a final static reference to an
 * instance of that class. In other words, enum types are a generalization of
 * singletons, because with singletons we have only one access point, but here
 * we can have as many as we desire.
 * 
 * To get an iterator over the enum set, use need to transform it into a proper
 * collection type, for example EnumSet. Then we can use it to iterate over the
 * set.
 * 
 * What happens when you remove an enumeration from a set? If a client does not
 * refer to it, they'd be fine. But if they do refer to it, the code will fail
 * with a clear error message.
 * 
 * Sometimes, we want to associate a particular operation with each enum. Java
 * lets us do this by defining an abstract method inside the enum class, and
 * then override it for each constant (cool!).
 */

enum Planet {
    // Literals and behavior. Note that as we know, each Literal is a singleton
    // class, hence
    // it's instantiated and it's methods can be used as instance methods.

    MERCURY(3.302e+23, 2.439e6), VENUS(4.869e+24, 6.052e6), EARTH(5.975e+24, 6.378e6), MARS(6.419e+23, 3.393e6),
    JUPITER(1.899e+27, 7.149e7), SATURN(5.685e+26, 6.027e7), URANUS(8.683e+25, 2.556e7), NEPTUNE(1.024e+26, 2.477e7);

    private final double mass;
    // In kilograms
    private final double radius;
    // In meters
    private final double surfaceGravity; // In m / s^2

    // Universal gravitational constant in m^3 / kg s^2
    private static final double G = 6.67300E-11;

    // Constructor
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double mass() {
        return mass;
    }

    public double radius() {
        return radius;
    }

    public double surfaceGravity() {
        return surfaceGravity;
    }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity; // F = ma
    }

    public static Iterator<Planet> getIterator() {
        return EnumSet.allOf(Planet.class).iterator();
    }

    public static void main(String[] args) {
        Planet planet = Planet.EARTH;
        System.out.println(planet.name());
        System.out.println(planet.mass());
        System.out.println(planet.surfaceGravity());
    }
}

/**
 * Define a basic calculator operation and then override it.
 */
enum Operation {
    Add {
        public double operation(double x, double y) {
            return x + y;
        }
    },

    Subtract {
        public double operation(double x, double y) {
            return x - y;
        }
    },

    Divide {
        public double operation(double x, double y) {
            return x * y;
        }
    },
    
    Multiply {
        public double operation(double x, double y) {
            return x / y;
        }
    };

    abstract public double operation(double x, double y);

}