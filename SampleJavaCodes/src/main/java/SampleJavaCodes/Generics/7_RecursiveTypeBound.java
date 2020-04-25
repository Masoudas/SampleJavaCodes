package SampleJavaCodes.Generics;

/**
 * I'm going to make sense of Recursive type bounds with a series of examples.
 * First, the meaning is that they bound the types with the own class that defines 
 * the generic. Hence, the generic can be the class type itself or it's subclasses.
 * Well, I think this should be clarifying in and of itself. We want the generic
 * to be bounded to this class type.
 * 
 */

/**
 * Example 1: Suppose we have a class hierarchy. Yet, we want a method to be overridden,
 * that returns a reference to each class type. Note that this is possible with
 * changing the return type, but when using base reference class, we would get the 
 * reference to base class reference, which is not what we seek!
 */
abstract class ReturnerReference1{
    public abstract ReturnerReference1 getReference();
}

class Returner1 extends ReturnerReference1{
    @Override
    public Returner1 getReference() {
        return new Returner1();
    }
    
    // When using base class reference, we would need a cast!
    public static void main(String[] args) {
        ReturnerReference1 retReference1 = new Returner1();
        Returner1 ref1 = (Returner1)retReference1.getReference();
    }
}


/**
 * To remedy this, we obviously need the return type of the method
 * to be a generic. That way, we ensure that the return type follows
 * the class type. Hence, we need the generic to say ReturnerRef<T extends ReturnerRef>
 * but this is incomplete. Because ReturnerRef is now a generic itself. This is why we
 * need to say ReturnerRef<T extends ReturnerRef<T>>
 */

abstract class ReturnerReference<T extends ReturnerReference<T>>{
    public abstract T getReference();
}

class Returner extends ReturnerReference<Returner>{
    @Override
    public Returner getReference() {
        return new Returner();
    }

    public static void main(String[] args) {
        ReturnerReference<Returner> returnerReference = new Returner();
        Returner returner = returnerReference.getReference(); // Wow! Using the reference of the base
                        // type, we got this. See 2_ConsiderABuilderWhenFacedWithManyConstructorParameters
                        // for a use of this in builder classes.

    }
    
}

/**
 * Example 2: We have the Comparable<T> interface which compares two elements.
 * Now, we want to implement a generic set of object, all which can be compared to one another.
 * Hence, we need the set generic to implement Comparable. Hence, Set<T extends Comparable>
 * But then again this is not complete, because we don't know what we want to compare to.
 * In other words, we need to bound the type of T to elements that can be compared to themselves.
 * Hence <T extends Comparable<T>>
 */

class Set<T extends Comparable<T>>{
    
} 