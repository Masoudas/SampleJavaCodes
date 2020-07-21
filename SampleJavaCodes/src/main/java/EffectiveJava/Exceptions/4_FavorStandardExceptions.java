/**
 * One reason why we want to use standard exceptions is that all of them are serializable.
 * But using a checked exception to add detail to an already standard exception is a good idea.
 * 
 * Most importantly, we let the users deal with known exceptions when throwing standard
 * exceptions. Moreover, fewer exception classes means a smaller memory footprint and 
 * less time spent loading classes.
 * 
 * The most commonly used exception is the IllegalArgumentException, for when arguments
 * don't follow a particular rule we set. Then there's the IllegalStateException, which is thrown
 * when the state of the receiving object is not correct. Then there's the 
 * Arguably, every erroneous method invocation boils down to an illegal argument
 * or state, but other exceptions are handy to convey more detail. Like for 
 * example the NullPointerException. IndexOutOfBoundsException is another exception.
 * ConcurrentModificationException is to be thrown when a resource is being modified
 * by two threads. UnsupportedOperationException is thrown when a method is not implemented
 * by a class.
 * 
 * Do not throw Exception, RunTimeException or Throwable directly, because we always want
 * to be more specific than that.
 * 
 * ArithmeticException and NumberFormatException are another exceptions that can be used.
 * 
 * Now suppose we've a deck of card, and then there's a method that gets a value on the 
 * size of the deck to do some action. If size of the value passed, we can throw
 * illegal argument or state exception. So which is better? The rule is that
 * if no argument values would have worked, throw illegal state exception (i.e, regardless of
 * what input we provided, we would've gotten an error), otherwise throw argument exception.
 */