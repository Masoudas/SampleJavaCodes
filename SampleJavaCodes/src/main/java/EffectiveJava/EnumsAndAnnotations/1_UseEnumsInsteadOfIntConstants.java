package EffectiveJava.EnumsAndAnnotations;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
 * set. Note also that essentially having if statements over the constants of an
 * enum inside the enum is not a good idea, unless we use to somehow return
 * a constant value.
 * 
 * What happens when you remove an enumeration from a set? If a client does not
 * refer to it, they'd be fine. But if they do refer to it, the code will fail
 * with a clear error message.
 * 
 * Sometimes, we want to associate a particular operation with each enum. Java
 * lets us do this by defining an abstract method inside the enum class, and
 * then override it for each constant (cool!). The overridden methods are known
 * as constant-specific method implementations. Of course as know, we can use
 * constant specific data as well.
 * 
 * We may also override the toString method. If we do so, we better write a from
 * string method. This method will iterate over the constants inside enum and
 * return one if it exists. It's yelling at us that what we should return is in
 * fact an optional, if no equivalent constant exists. See below an
 * implementation. The premise is to keep a dictionary with string value
 * representation of the constants. Especially pay attention to how we return
 * the optional. Because the get method of the dictionary returns null, we use
 * the ofNullable creator of optional to return the value.
 * 
 * Note that with enums, they can't access other's instance variables. They
 * can't also access static variables of the enum except for the final static
 * primitive types.
 * 
 * So let's say we have an enum called PayRoll day. Then suppose we want to
 * calculate the salary for each day. Of course we can do this with a public
 * static method that entails a switch statement. The problem is that as we add
 * special cases (see vacation days), we may not update the switch and cause
 * problems. We may define an abstract class like before and override it. The
 * problem is that this would cause repetitive code. Of course, adding side
 * classes is another option, but it adds to code, and maintenance issues.
 * Moreover, overriding the static method for each enum constant is not a good
 * idea, because we may forget about overriding. The idea then would be to move
 * the salary computation method into another separate nested enum inside the
 * enum. Hence, evey time we want to calculate the salary, we ask what sort of
 * method we should use to do so. See example below! Cool. This is the 
 * strategy enum inside the enum by the way.
 * 
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
    Planet(double mass, double radius) {PayRollDay
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

    public static Iterator<Planet> getIteratorMethod1() {
        return Arrays.asList(values()).iterator();
    }

    public static Iterator<Planet> getIteratorMethod2() {
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

enum EnumWithStringConverter {
    Val1, Val2;

    private final static Map<String, EnumWithStringConverter> map = Stream.of(values())
            .collect(Collectors.toMap(Object::toString, t -> t));

    public static Optional<EnumWithStringConverter> fromString(String constant) {
        return Optional.ofNullable(map.get(constant));
    }
}

enum CantAccessOtherEnumsInsideConstructor {
    Val1(1), Val2(2);

    private static final int[] staticReferenceType = new int[2];
    private static final int staticFinalVal = 10;
    private int instanceField = 0;

    private final int finalInstanceField = 0;

    CantAccessOtherEnumsInsideConstructor(int y) {
        // Why can I print this? Well, because the Object constructor has been called
        // before here.
        // Hence, you can have a string representation of the string. However, you can't
        // access the instance filed associated with a constant.
        System.out.println(EnumWithStringConverter.Val1.toString());

        // System.out.println(Val1.instanceField); This violates the access, because the
        // field may
        // not have been constructed still!
        // System.out.println(Val1.finalInstanceField); Not even if they're final

        System.out.println(staticFinalVal); // This is completely valid, and the only access allowed by enums.

        // staticReferenceType[0] = 5; This again is prohibited. I've no idea why. The
        // book says if it were legal. it would return a null pointer exception. But
        // why?

    }
}

enum PayrollDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    PayrollDay(PayType payType) { this.payType = payType; }

    PayrollDay() { this(PayType.WEEKDAY); } // Default

    int pay(int minutesWorked, int payRate) {
        return payType.pay(minutesWorked, payRate);
    }

    private enum PayType {
        WEEKDAY {
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked <= MINS_PER_SHIFT ? 0 : (minsWorked - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND {
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked * payRate / 2;
            }
        };

        abstract int overtimePay(int mins, int payRate);

        private static final int MINS_PER_SHIFT = 8 * 60;

        int pay(int minsWorked, int payRate) {
            int basePay = minsWorked * payRate;
            return basePay + overtimePay(minsWorked, payRate);
        }

    }

}
