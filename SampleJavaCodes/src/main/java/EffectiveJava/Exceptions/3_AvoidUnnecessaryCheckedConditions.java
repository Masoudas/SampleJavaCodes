/**
 * As is obvious, we should avoid throwing checked conditions all the time, because
 * dealing with them in the API is unpleasant. Especially given that stream library
 * does not allow methods with checked exceptions to be directly used.
 * 
 * So let's say the API user has to do either of the following:
 * } catch (TheCheckedException e) { 
 * throw new AssertionError(); // Can't happen!
 * } Or this? 
 * } catch (TheCheckedException e) {
 * e.printStackTrace();  // Oh well, we lose.  
 * System.exit(1); 
 * }
 * 
 * Then in both cases, the API user can't take any further actions. Hence, in both
 * cases, throwing an unchecked exception is recommended.
 * 
 * Moreover, we can transform a checked exception into an unchecked one. For this end, we
 * can have a check state method that returns a boolean. Then the actual method throws an
 * unchecked exception (this is what happens with the iterator as discussed in item 1)
 */