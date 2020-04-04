package EffectiveJava.CreatingAndDestroyingObjects;

import java.util.Set;

/**
 * Not to be confused with factory pattern, one interesting idea is to use
 * static factory methods in the class that allows for meaningful creation of an
 * object. These static methods can be used in lieu of the actual constructors.
 * It has even been suggested to put these methods as static in the interface of
 * the class.
 * 
 * There are benefits, as well as limitations: Benefits: 1- Unlike constructors,
 * they have names: Some idiots change the placement of arguments in signature
 * to indicate different object creation process. Static methods remedy that.
 * 
 * 2- Make class immutable: Sometimes only having one instance of a class is
 * sufficient, as is perfectly demonstrated by Enum class. Static methods allow
 * for that. We don't need to create a new class every time.
 * 
 * 3- Hide the type of subclasses: We can return any subclass of the calling
 * function when using the static method, and we don't have to show their
 * presence in API. This is best summarized by java.util.Collections, which is a
 * non-instantiable class, providing only factories for 45 implementations. (see
 * below).
 * 
 * 4- Change the return type from call to call: Let's consider enumSet. Enum set
 * uses a default long implementation to create an enum, but there's a larger
 * long[] version. Static factory method allow for construction of the derived
 * classes, without divulging them to the users.
 * 
 * 5- The class of the returned method need not exist when writing the method:
 * 
 * 
 * 
 * Limitations: 1- Subclassing is impossible: If we don't give out protected or
 * public constructors, then inheriting that class becomes impossible. Hence, we
 * should be careful
 * 
 * 2- Hard to find in API: Sometimes the methods will be hard to find. Suggested
 * names to make them easy to find: 1- an of() method. 2- an instance() method.
 * 3- an instanceOf() method. 4- an getInstnace() method. 5- an getType() of
 * Type() method. 6- an valueOf() method.
 * 
 */

class IllustrationPoints{
    public void allFactoryMethodsOfCollections(String[] args) {
        Set<Object> set = java.util.Collections.emptySet();
        java.util.Collections.emptyMap();

    }
}