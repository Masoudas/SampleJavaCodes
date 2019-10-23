/**
 * This library contains classes that generate pseudorandom 
 * numbers, manage date and time, observe events, manipulate sets of bits, 
 * tokenize strings, and handle formatted data.
 * 
 * The java.util package also 
 * contains one of Java’s most powerful subsystems: the Collections Framework. * 
 * 
 * 
 * Beginning with JDK 9, java.util is part of the java.base module
 * 
 * Bascially, we have interfaces, and then implementations of those interfaces.
 * Interfaces:
 * 1- Collection: The top level interface. Note that collection types do not allow primitive
 *                types to be used as generic elements. We can only use reference types.
 * 2- List: The List interface extends Collection and declares the behavior of a collection 
 *          that stores a sequence of elements. Elements can be inserted or accessed by 
 *          their position in the list, using a zero-based index. A list may contain duplicate 
 *          elements.
 * 3- Set: The Set interface defines a set. It extends Collection and specifies the behavior 
 *         of a collection that does not allow duplicate elements. Therefore, the add( ) 
 *         method returns false if an attempt is made to add duplicate elements to a set
 *   
 * 4- OrderedSet: The SortedSet interface extends Set and declares the behavior of a set sorted in 
 *                ascending order 
 * 
 * 5- NavigableSet: The NavigableSet interface extends SortedSet and declares the behavior of a 
 *                   collection that supports the retrieval of elements based on the closest match to
 *                   a given value or values
 * 
 * 6- Queue: Defines the queue interface, which is first in first out (mostly).
 * 
 * 7- Deque: The Deque interface extends Queue and declares the behavior of a double- 
 *           ended queue. Double-ended queues can function as standard, first-in, first-out 
 *           queues or as last-in, first-out stacks
 * 
 * 
 * And then there are implementations of these classes. There are abstract implementations,
 * like AbstractCollection, AbstractList, AbstractQueue and so forth, and then 
 * there are actual implementations, like ArrayList, LinkedList, HashTable, EnumSet and so forth.
 * The collection classes are not synchronized, but it is possible to obtain synchronized
 * versions as well,
 * 
 * If we seek a particular need, we can which interfaces are used by the class we need. For example,
 * if RandomAccess interface is implemented, then random access to the elements of the set is possible,
 * although this may not be efficient. If the set interface is implemented, then we have set like structure
 * and so forth. 
 * 
 * So when we want to use these collection classes, we must ask ourselves what we seek.
 * 1- If we seek to access elements with indexing, then we use classes that have a List
 *    in their keyword. 
 * 2- If we seek No repetition, then we use classes with Set.
 * 3- If we seek HashLike access, then classes with Hash.
 * 4- Tree like, we use classes that have the name Tree.
 * 
 * 
 */