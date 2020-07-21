
/**
 * We maybe tempted to write a for loop like this. Why? To avoid checking
 * for the termination condition of a loop:
 * // Horrible abuse of exceptions. Don't ever do this! 
 * try { 
 * int i = 0; 
 * while(true) range[i++].climb(); 
 * } catch (ArrayIndexOutOfBoundsException e) { 
 * }
 * 
 * So the loop does its function and terminates when we get out of the array bounds.
 * But this is wrong in one hundred ways. Including the fact that the normal for each loop
 * is optimized to be faster than an exception. An exception is not generally optimized
 * by compiler, because exceptional cases are supposed to happen rarely. Also, the climb
 * method might throw the same exception type somewhere inside, and we terminate the
 * loop for unknown reasons.
 * 
 * Exceptions are, as their name implies, to be used only for exceptional conditions;
 * they should never be used for ordinary control flow.
 * 
 * With state dependent methods, you want to first check the state (without any exception)
 * and then do the state dependent function. Like for example with an iterator, we first want to 
 * check if we have a next state, then iteratre, not throw an exception everytime there's no
 * next state.
 * 
 * Hence we need to choose between a state testing method, and optional and an exception.
 * If an object is to be accessed concurrently without external synchronization or is subject to externally induced 
 * state transitions, you must use an optional or distinguished return value (like null), as the 
 * object’s state could change in the interval between the invocation of a state-testing 
 * method and its state-dependent method
 * Performance concerns may dictate that an optional or distinguished return value be used
 * if a separate state-testing method would duplicate the work of the state-dependent method. 
 * All other things being equal, a state-testing method is mildly preferable to a distinguished 
 * return value or an optional.
 * 
 */