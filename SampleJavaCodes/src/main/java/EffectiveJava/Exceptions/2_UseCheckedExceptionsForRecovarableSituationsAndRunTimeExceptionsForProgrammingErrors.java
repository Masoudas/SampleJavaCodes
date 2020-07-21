/**
 * (Me: As I've witnessed over time, some exceptions are forced to be caught (like the ones 
 * I create myself), and some are not forced to be caught. The exceptions that are forced
 * to be dealt with are called checked exceptions, because the user of the API is forced
 * to deal with them. Unchecked exceptions on the other hand are the sort of exceptions
 * that force the program to terminate, because we believe continuing the program as such
 * is more harmful. An example is the null exception)
 * 
 * Java provides three kinds of throwables: checked exceptions, runtime exceptions, and errors.
 * 
 * Checked exceptions force the user of the API to deal with the exceptional case.
 * 
 * Runtime exceptions are thrown implicitly, and are not forced to be caught. RunTimeException is an
 * example of such an exception.
 * 
 * Errors are the sort of exceptions that are reserved essentially for the JVM (although
 * we can extend them, we should not). Errors are also unchecked exceptions. OutOfMemoryException
 * is an example of such exception. HENCE, all of the unchecked throwables you implement 
 * should subclass RuntimeException 
 * 
 * When should we throw checked exceptions: When we know that user of the API can reasonably
 * recover from the error. Otherwise, we throw unchecked exceptions.
 * 
 * Use runtime exceptions to indicate programming errors. The great majority of runtime exceptions 
 * indicate precondition violations. 
 * 
 * Always a good idea to indicate with an exception class why the code has failed,
 * using different methods inside the exception for example.
 * 
 */