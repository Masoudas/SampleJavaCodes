package EffectiveJava.Generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Genrics allow type check at compile time, because with old method of Objects,
 * we could only check cast at run-time. he compiler inserts casts for you
 * automatically and tells you at compile time if you try to insert an object of
 * the wrong type.
 * 
 * 
 * As we know, raw types are generic types that are not parameterized.
 * 
 * If I say Collection stamps = new Collection(); I can put coins here too. But,
 * if I try to retrieve the stamps and cast to stamp (because this is a raw of
 * Object, and I need to cast from Object to stamp), I get an error. We're not
 * using the compile time benefits of the generic, but rather the runtime error
 * is used here.
 * 
 * Note that if a type T is not bounded in Cls<T>, we can't say Cls<Object> cls
 * = new Cls<Integer>. This is because generics are supposed to ensure that type
 * is strictly enforced. Otherwise with this definition, we could easily say
 * cls.set("string"), and assign an string to integer! So regard the raw types
 * as exceptional, and always note that type is strictly forced (in short, just
 * image getting an element and working with it!).
 * 
 * What is the difference between List and List<Object>? The former has opted
 * out of the generic system, while the latter is still in the circle. The
 * latter explicitly tells the compiler that it can hold an object of anytime,
 * while the former does not. So you can say:
 * 
 * List list = new List<String>();
 * 
 * But you can't say:
 * 
 * List<Object> list = new List<String>();
 * 
 * Consider the following example. We use the unsafe add. It only returns the
 * error at runtime if try to assign a let's say integer. Whereas with
 * List<Object> list, we can't use this unsafeAdd method in the first place.
 */

class PassingRawTypeIsWrong {
    // Fails at runtime - unsafeAdd method uses a raw type (List)!
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        String s = strings.get(0); // Has compiler-generated cast
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}

/**
 * Don't use raw types for when the generic class does not matter. You would
 * want to use wild cards here.
 * 
 * Again, we're just saying to the compiler we want to use the advantages of
 * generic types. Moreover, You can put any element into a collection with a raw
 * type, easily corrupting the collection’s type invariant (as demonstrated by
 * the unsafeAdd); you can’t put any ele- ment (other than null ) into a
 * Collection<?> . So the unsafeAdd if it were implemented by wild card wouldn't
 * let you add any parameteres!!!!
 * 
 * There are a few minor exceptions to the rule that you should not use raw
 * types. You must use raw types in class literals. The specification does not
 * permit the use of parameterized types (though it does permit array types and
 * primitive types) [JLS, 15.8.2]. In other words, List.class , String[].class ,
 * and int.class are all legal, but List<String>.class and List<?>.class are
 * not. See
 * https://docs.oracle.com/javase/tutorial/extra/generics/literals.html.
 * 
 * A second exception to the rule concerns the instanceof operator. Because
 * generic type information is erased at runtime, it is illegal to use the
 * instanceof operator on parameterized types other than unbounded wildcard
 * types. The use of unbounded wildcard types in place of raw types does not
 * affect the behavior of the instanceof operator in any way. In this case, the
 * angle brackets and question marks are just noise. This is the preferred way
 * to use the instanceof operator with generic types:
 * 
 * // Legitimate use of raw type - instanceof operator
 * 
 * if (o instanceof Set) { Raw type Set<?> s = (Set<?>) o; // Wildcard type ...
 * }
 * 
 * Note that once you’ve determined that o is a Set , you must cast it to the
 * wildcard type Set<?> , not the raw type Set . This is a checked cast, so it
 * will not cause a compiler warning.
 */
class DontUseRawTypesForUnimportantTypes {
    // Use of raw type for unknown element type - don't do this!
    static int numElementsInCommon(Set s1, Set s2) {
        int result = 0;
        for (Object o1 : s1)
            if (s2.contains(o1))
                result++;
        return result;
    }

    static int numElementsInCommonWithWildCards(Set<?> s1, Set<?> s2) {
}