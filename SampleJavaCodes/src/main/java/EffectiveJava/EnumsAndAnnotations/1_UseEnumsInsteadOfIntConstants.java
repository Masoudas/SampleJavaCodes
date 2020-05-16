package EffectiveJava.EnumsAndAnnotations;

/**
 * enums and Annotations are two special types. an enum type is a type whose
 * legal values consist set of constant literals.
 * 
 * The problem with int literals is that, they can't be checked propely (and
 * that's why we use enum type in the first place).
 * 
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!DIDN'T FINISH THIS!!!!!!!!!!!!!!!!!!!!!!1
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

    public static void main(String[] args) {
        Planet planet = Planet.EARTH;
        System.out.println(planet.name());
        System.out.println(planet.mass());
        System.out.println(planet.surfaceGravity());
    }
}