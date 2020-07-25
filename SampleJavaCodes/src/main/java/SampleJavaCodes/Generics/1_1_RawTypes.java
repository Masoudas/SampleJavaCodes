package SampleJavaCodes.Generics;

/**
 * A raw type is the name of a generic class or interface without any type
 * arguments. For example, given the generic Box class:
 */
class Box<T> {
    public void set(T t) {
        /* ... */ }
    // ...

    public static void main(String[] args) {
        // To create a parameterized type of Box<T>, you supply an actual type argument
        // for the formal type parameter T:

        Box<Integer> intBox = new Box<>();

        // If the actual type argument is omitted, you create a raw type of Box<T>:

        Box rawBox = new Box();

    }
}

/**
 * Raw types show up in legacy code because lots of API classes (such as the
 * Collections classes) were not generic prior to JDK 5.0. When using raw types,
 * you essentially get pre-generics behavior. Note that with raw types, the type
 * is erased and replaced with the upper bound of the generic (be it object or
 * any other type that is the upper bound).
 * 
 * WARNING: Don't forget that Raw type replaces generic type with upper bound,
 * not Object!
 */
class GenericClass<T extends Number> {
    T t;

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        GenericClass raw = new GenericClass<Integer>();
    }
}
