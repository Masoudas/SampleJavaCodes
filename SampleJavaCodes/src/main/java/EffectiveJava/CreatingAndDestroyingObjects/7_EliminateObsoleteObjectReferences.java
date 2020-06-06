package EffectiveJava.CreatingAndDestroyingObjects;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * As is evident, the problem with the following implementation of stack is that
 * when the item is popped out of the active portion of the stack (meaning up to
 * size), then it will still remain inside the array (and in other words inside
 * memory). Hence, we tend to get outOfMemory. To avoid this we null the
 * reference by writing Object element = elements[--size]; and then
 * elements[size] = null;
 * 
 * Note that nulling objects should be the exception rather than the norm.
 * 
 * When should we null objects? When an object manages its own memory, like the
 * example we saw here. Also caching objects is an important reason why this
 * happens.
 * 
 * When caching, WeakHashMaps can be used. If you’re lucky enough to implement a
 * cache for which an entry is relevant exactly so long as there are references
 * to its key outside of the cache, represent the cache as a WeakHashMap;
 * entries will be removed automatically after they become obsolete (See example
 * below).
 * 
 * More commonly, the useful lifetime of a cache entry is less well defined,
 * with entries becoming less valuable over time. Under these circumstances, the
 * cache should occasionally be cleansed of entries that have fallen into
 * disuse. This can be done by a background thread (perhaps a
 * ScheduledThreadPoolExecutor ) or as a side effect of adding new entries to
 * the cache. The LinkedHashMap class facilitates the latter approach with its
 * removeEldestEntry method. For more sophisticated caches, you may need to use
 * java.lang.ref directly.
 * 
 * A third common source of memory leaks is listeners and other callbacks. If
 * you implement an API where clients register callbacks but don’t deregister
 * them explicitly, they will accumulate unless you take some action. One way to
 * ensure that callbacks are garbage collected promptly is to store only weak
 * references to them, for instance, by storing them only as keys in a
 * WeakHashMap . Because memory leaks typically do not manifest themselves as
 * obvious failures, they may remain present in a system for years. They are
 * typically discovered only as a result of careful code inspection or with the
 * aid of a debugging tool known as a heap profiler. Therefore, it is very
 * desirable to learn to anticipate problems like this before they occur and
 * prevent them from happening.
 */

class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }

    /**
     * Ensure space for at least one more element, roughly doubling the capacity
     * each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

}

class WeakHashMapUse {
    private static void strongSoftAndWeakReference() {
        // The variable prime has a strong reference to object 1.
        // Any object with strong reference is not garbage collected.
        Integer prime = 1;

        // Any object with soft reference will remain in memory, until the JVM
        // absolutely needs memory,
        // then it is GCed
        Integer prime1 = 1;
        SoftReference<Integer> softReference = new SoftReference<Integer>(prime1);
        prime1 = null;

        System.out.println(softReference.get()); // This reference is valid, but if JVM absolutely needs memory, will
                                                 // perish

        // Any object with weak reference will remain in memory, but JVM will
        // be eager to remove it and use its memory instead.
        Integer prime2 = 1;
        WeakReference<Integer> weakReference = new WeakReference<Integer>(prime2);
        prime2 = null;

        System.out.println(weakReference.get()); // This reference becomes invalid as soon as JVM needs memory, which
        // is not right now!

    }

    public static void main(String[] args) {
        strongSoftAndWeakReference();
        whatIsWeakHashMap();

    }

    private static void whatIsWeakHashMap() {
        String key1 = "A";

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(key1, "A");

        WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();
        weakHashMap.put(key1, "A");

        System.out.println(hashMap.size());
        System.out.println(weakHashMap.size());

        // Now we null the key
        key1 = null;

        // We see that all of a sudden, the strong hash map keeps everything, whereas
        // the weak has removed everything, or removes every key as soon as JVM needs
        // memory.
        // The point is that if the dictionary is the only remaining reference, we don't
        // remove it
        // with the strong hashmap, whereas we remove it with the weak one.
        System.out.println(hashMap.size());
        System.out.println(weakHashMap.size());

    }
}