package SampleJavaCodes.Generics.TypeErasure;

/**
 * Generics were introduced to the Java language to provide tighter type checks
 * at COMPILE TIME and to support generic programming.
 * 
 * What is type erasure? Obviously it has something to do with erasing the type
 * (of a generic). It means a generic type is replaced by its upper bound (i.e,
 * if we specified a bound by that, otherwise by Object) at compile time. We say
 * that it's compile time because while the code is compiled, it is replaced by
 * upper bound it is checked that for example if a method is used from the
 * bounded type, it in fact exists. Then obiously at runtime, we have replaced
 * it with upper bound if we did at compile time.
 * 
 * This would allow not to impose any additional runtime burdon. It does make
 * sense, because after all if we use a generic and we define an upperbound,
 * that bound is there to ensure that we have access to some methods (which are
 * obviously in the bound). Therefore from the compiler point of view, it
 * completely makes sense to just replace the generic with the upper bound.
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
 * Object (again, at compile time):
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
 * Because it is in and of itself a generic type. The answer is that comparable
 * in the original declaration T extends Comparable<T> works on objects! Why?
 * Because we have Comparable<T>, and T is not bounded by anything other than
 * this interface, not a rigorous type like string. Hence, Comparable uses
 * object. But if it were like <T extends String, Comparable<T>>, Comparable
 * would be implemented with String. )
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
 * Note that with this baby,T would be both of the type Number and comparable.
 * But then again, what happens to the Com
 * 
 * @param <T>
 */
class Node2<T extends Number & Comparable<T>> {
    T t; // I imagine this would be a reference to both comparable and number.
         // We know the reference to the number part fine,
         // but then again, the Comparable part has to be related to Number,
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
