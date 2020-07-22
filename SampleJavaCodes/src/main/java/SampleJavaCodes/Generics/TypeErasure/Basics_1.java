package SampleJavaCodes.Generics.TypeErasure;

/**
 * What is type erasure? Obviously it has something to do with erasing the type
 * (of a generic). It means a generic type is replaced by its upper bound (i.e,
 * if we specified a bound by that, otherwise by Object). This would allow not
 * to impose any additional runtime burdon. In a way it does make sense, because
 * after all if we use a generic and we define an upperbound, that bound is
 * there to ensure that we have access to some methods (which are obviously in
 * the bound). Therefore from the compiler point of view, it completely makes
 * sense to just replace the generic with the upper bound.
 * 
 * Officially Oracle says Java applies type erasure to ensure that:
 * 
 * 1- It replaces all type parameters in generic types with their bounds or
 * Object if the type parameters are unbounded. The produced bytecode,
 * therefore, contains only ordinary classes, interfaces, and methods.
 * 
 * 2- Insert type casts if necessary to preserve type safety.
 * 
 * 3- Generate bridge methods to preserve polymorphism in extended generic types
 * 
 * During the type erasure process,the Java compiler erases all type parameters
 * and replaces each with its first bound if the type parameter is bounded,or
 * Object if the type parameter is unbounded.
 * 
 * Consider the following generic class that represents a node in a singly
 * linked list:
 */

class Node<T> {

    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }
    // ...
}

/**
 * Because the type parameter T is unbounded, the Java compiler replaces it with
 * Object:
 */

class NodeAsImplementedByJVM {

    private Object data;
    private NodeAsImplementedByJVM next;

    public NodeAsImplementedByJVM(Object data, NodeAsImplementedByJVM next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }
    // ...
}

/**
 * In the following example, the generic Node class uses a bounded type
 * parameter:
 */

class Node1<T extends Comparable<T>> {

    private T data;
    private Node1<T> next;

    public Node1(T data, Node1<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }
    // ...
}

/**
 * The Java compiler replaces the bounded type parameter T with the first bound
 * class, Comparable: (Me: The question is though, what happens to Comparable?
 * Below for example Comparable is wiggly? Well, wouldn't it be replaced by
 * Object? I guess so. Then again, T extends Comparable<T> implies the same
 * logic, doesn't it? Because after all, T is bounded by comparable, which is
 * just an interface, but its own type (be it integer or whatever) is unknown.
 * We just know that it provides a comparable method.)
 */

class Node1ByJEM {

    private Comparable data;
    private Node1ByJEM next;

    public Node1ByJEM(Comparable data, Node1ByJEM next) {
        this.data = data;
        this.next = next;
    }

    public Comparable getData() {
        return data;
    }
    // ...
}

/**
 * The same situation happens with methods as well
 * 
 * The Java compiler also erases type parameters in generic method arguments.
 * Consider the following generic method:
 * 
 * // Counts the number of occurrences of elem in anArray. // public static <T>
 * int count(T[] anArray, T elem) { int cnt = 0; for (T e : anArray) if
 * (e.equals(elem)) ++cnt; return cnt; }
 * 
 * Because T is unbounded, the Java compiler replaces it with Object:
 * 
 * public static int count(Object[] anArray, Object elem) { int cnt = 0; for
 * (Object e : anArray) if (e.equals(elem)) ++cnt; return cnt; }
 * 
 * Suppose the following classes are defined:
 * 
 * class Shape {} class Circle extends Shape {} class Rectangle extends Shape {
 * } You can write a generic method to draw different shapes:
 * 
 * public static <T extends Shape> void draw(T shape) { }
 * 
 * The Java compiler replaces T with Shape:
 * 
 * public static void draw(Shape shape) { }
 * 
 */
