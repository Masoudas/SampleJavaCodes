package EffectiveJava.CreatingAndDestroyingObjects;


/**
 * Singletons happen when a class has stateless methods only, or we have a class
 * that is meaningful to be created only once. We have three approaches to
 * implement it.
 * 
 * The first method makes everything 100% static, which is good. We have exactly
 * one instance, its in this field. Also the user of API can easily recognize
 * and understand that this is a singleton. Which is not 100* apparent with the
 * next approach. Constructor throws exception when attempting to reuse with
 * reflection!
 * 
 * The advantage of the second over the first is that if we decide in the future
 * to change our mind and actually create instances, or create several static
 * instances, we can do it! Constructor throws exception when attempting to
 * reuse with reflection!
 * 
 * Now, a problem of the approaches is serialization. It's not suffiecent to
 * just add implements serializable, because the serializable makes an instance
 * of the object. We need to declare all fields transient too, and provide a
 * readResolve method as well.
 * 
 * The third way is to actually use enums. So enums have this property that
 * every literal works like an instance of the class. Hence, every non-static
 * field or behavior of the class can be used with them. The implementation is
 * seen below. The most important advantage of this approach is that we don't
 * have to deal the serialization stuff or attacks using reflection to use
 * private constructors. The two issues are first enums can't extend a base
 * class, and the second one is that I kind of don't like this method! That's
 * not what enums are out there for!
 */
class WithPublicStaticField {
    /**
     * We know that this creation does not cause stack overflow because the
     * constructor is private :D!
     */
    public static final WithPublicStaticField INSTANCE = new WithPublicStaticField();

    private WithPublicStaticField() {
        if (INSTANCE != null) {
            throw new IllegalAccessError("Class has already been instantiated");
        }
    }

    public void someMethod() {

    }

}

class WithPublicStaticMethod {
    private static final WithPublicStaticMethod INSTANCE = new WithPublicStaticMethod();

    public static WithPublicStaticMethod instance() {
        return INSTANCE;
    }

    private WithPublicStaticMethod() {
        if (INSTANCE != null) {
            throw new IllegalAccessError("Class has already been instantiated");
        }
    }

    public void someMethod() {
    }

}

enum WithEnum {
    INSTANCE;

    public void someMethod() {

    }
}
