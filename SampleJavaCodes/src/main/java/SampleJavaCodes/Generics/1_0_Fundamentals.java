package SampleJavaCodes.Generics;

/** 
 * Genrics allow type check at compile time, because with old method of Objects,
 * we could only check cast at run-time. The compiler 
 * inserts casts for you automatically and tells you at compile time if you try to insert 
 * an object of the wrong type 
 * 
 * Generics are known as parametrized types. In other words, they let us treat the  
 * the types as parameters.  
 * 
 * Generic classes and interfaces are collectively known as generic types (something
 * that uses generics). 
 * 
 * Each generic type defines a set of parameterized types, using angle brackets, which consist of the 
 * class or interface name followed by an angle-bracketed list of actual type 
 * parameters corresponding to the generic type’s formal type parameters.
 * 
 * Finally, each generic type defines a raw type, which is the name of the generic 
 * type used without any accompanying type parameters
 * 
 * A class or interface whose declaration has one or more type parameters is a
 * generic class or interface 
 * 
 * Generics in Java and templates in C++ are totally different. For one thing, 
 * generics don't accept primitive types.
 * 
 * 
 * Note that generic type information is erased at runtime, it is only enforced at compile
 * time. This is why we call generics non-reifiable (less information about the variable
 * at runtime compared to compile type). The opposite are arrays, which are refiable!
 * 
 * */

/**
 * Fundamentals
 */

class Example<T, V> {
    private T t;
    private V v;

    public Example(T t) {
        // We can print out the type of T, but not its actual content.
        this.t = t;
        System.out.println(t.getClass().getName());
    }

    public T getObj() {
        // This would get the generic type value (duh!)
        return t;
    }

    public static void main(String[] args) {
        // Note that to instantiate with the integer type, we need to use the Integer
        // class,
        // not the integer type. In other words, int is not enough!
        Example<Integer, String> example = new Example<Integer, String>(5); // The fact that we can assign 5 to an
                                                                            // Integer class is called auto-boxing.
        int v = example.getObj(); // Unboxing allows this operation to be valid.

        Example<Float, String> example1 = new Example<Float, String>(5.1F);
        float v1 = example1.getObj();

        int[] vec = { 1, 2, 3 }; // Well, because vec is a class, this declaration is alright.
        Example<int[], String> example2 = new Example<int[], String>(vec);
        int[] vec1 = example2.getObj();

    }
}

// Next however, suppose we tried to generate the same code, but using object
// type instead of generics.
class ExampleWithGenerics {
    Object t;

    public ExampleWithGenerics(Object t) {
        // We can print out the type of T, but not its actual content.
        this.t = t;
        System.out.println(t.getClass().getName());
    }

    public Object getObj() {
        // This would get the generic type value (duh!)
        return t;
    }

    public static void main(String[] args) {
        // When instantiating the class, we can use the boxing feature.
        ExampleWithGenerics example1 = new ExampleWithGenerics(5);

        // However, we need a type cast when getting the object.
        int v = (int) example1.getObj();

        // Another issue that arises is that several illogical assignments can be done.
        ExampleWithGenerics example2 = new ExampleWithGenerics("This is an string type");
        example1 = example2;

    }

}

/*
 * When we talk about the type safety of generics, we mean that a generic of for
 * example type Integer cannot be assigned to a generic of type string. This for
 * example is not the case if we used objects, or RAW types, RAW types were
 * provided to make transition from the era of no generics (JDK5) to the era of
 * with generics possible (below). Anyways, don't use raw types
 */

/**
 * 1_Fundamentals
 */
class RAWTypes {
    public static void main(String[] args) {
        // Bizzare syntax
        Example ex = new Example(Integer.valueOf(5));

    }

}