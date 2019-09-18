package SampleJavaCodes.Generics;

/**
 * GenericInterfaces
 */
interface genericInterface<T extends Comparable<T>>{
    public T min();
    public T max();
}