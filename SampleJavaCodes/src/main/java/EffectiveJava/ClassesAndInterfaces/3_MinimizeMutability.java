/**
 * The preference is with horizontal and vertical mutability. We don't want the
 * state of the class to change (horizontal), and we don't want the class to be
 * inherited (vertically).
 * 
 * Here are five steps to make the class immutable: 1- Don't provide methods
 * that modify the state of the class.
 * 
 * 2- Make all fields final.
 * 
 * 3- Make all fields private.
 * 
 * 4- Ensure that the class cannot be inherited: This happens by either
 * declaring the class final, or, wait for it, make all constructors private/
 * 
 * 5- If class has mutuable state, ensure that clients cannot get an instance of
 * those objects
 * 
 * For example, in an immutable class called Complex, we define two methods
 * called plus, minus (rather than add and subtract). Why? These methods would
 * return new instances, hence, if we were to call them add, we would have
 * implied adding to the original objects. Apparanetly, classes like BigInteger
 * do not satisfy this rule.
 * 
 * 
 * For example, the BigInteger class can be inherited, eventhough it has
 * immutable behavior. Hence, a client may write code that alters the internal
 * structure. We should make sure to check for type then.
 * 
 * Resist the urge to write a setter for any getter.
 * 
 * We may cache the mutuable part of an otherwise immutable class. For example,
 * when we compute the hashcode method, if it's too expensive, we can cach it
 * and return it in the later uses. This is called lazy initialization.
 * 
 * Immutability can be reduced in small measures. For example, the
 * CountDownLatch is not an immutable class, in the sense that it's internal
 * state changes. However, it only counts down from a certain value, and once it
 * finishes, it expires. Hence, the state cannot be modified externally.
 * 
 * Constructors should create fully initialized objects with all of their
 * invari- ants established. Don’t provide a public initialization method
 * separate from the constructor or static factory unless there is a compelling
 * reason to do so. Similarly, don’t provide a “reinitialize” method that
 * enables an object to be reused as if it had been constructed with a different
 * initial state. Such methods generally provide little if any performance
 * benefit at the expense of increased complexity.
 * 
 * If you write a class with one mutable parameter (that is otherwise immutable)
 * and are implementing the Serializable interface, where apparently we need
 * access to all fields (including mutable). Make sure that it's safe under
 * attack.
 * 
 * The catch however to all of this is object construction and garbage
 * collection (if we can't cache instnaces most commonly used).
 */