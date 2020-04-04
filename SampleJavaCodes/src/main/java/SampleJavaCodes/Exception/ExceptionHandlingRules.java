package SampleJavaCodes.Exception;

/**
 * 1- Always handle exceptions at the highest level possible: Don't handle an
 * exception in the middle of the software, because the errors more often than
 * not should be seen by the API user.
 * 
 * 2- Exception chaining: Avoid hiding an exception. If you write a catch phrase in the middle of
 * the code, then when printing stack, that exception is hidden. Always use if
 * clause rather than a catch phrase. Although bear in mind you can pass the
 * stack trace to the newly generated exception (see class hiding exception).
 * We tend to add the hidden exception using addSuppressed().
 */

class HidingException {
    // Normally, when we throw an excpetion, we hide it. This is because we use
    // a catch block.
    public static void hiding() {
        try {
            int x = 1 / 0;
            
        } catch (ArithmeticException e) {
            // The newly generated exception hides Arithemtic error.
            throw new NullPointerException();
        }
    }

    // Normally, when we throw an excpetion, we don't hide it. If you see the stack
    // trace, you see that both the division by zero and null pointer exception are thrown.
    public static void noHiding() throws NullPointerException{
         try {
            int b = 1/0 ; 
         } catch (ArithmeticException e) {
            NullPointerException exception = new NullPointerException();
            exception.addSuppressed(e);
            throw exception;
         } 
         
     }

    public static void main(String[] args) {
        hiding();
        // noHiding();
    }
}
