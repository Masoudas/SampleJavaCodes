package SampleJavaCodes.Exception;

/**
 * Apparently in a try catch block, the only part that's expensive is the catch
 * phrase. One reason this is expensive is because we need to print stack.
 * 
 * To avoid gathering the stack, we can suppress its gathering. Note however that
 * this should be done only in trivial cases, where we know where and why an
 * exception occurs.
 */

 class ExceptionNoTrace extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ExceptionNoTrace(String message, boolean suppressStacktrace){
        super(message, null, suppressStacktrace, !suppressStacktrace);
    }

    public static void main(String[] args) throws ExceptionNoTrace {
        // Uncomment the lines to compare!
        throw new ExceptionNoTrace("Suppressed, but shows a message", true);

        // throw new ExceptionNoTrace("UnSuppressed", false);
    }
     
 }