/**
 * Java has three built-in annotations: 1- @Override 2- @Deprecated
 * 3- @SupressWarnings
 * 
 * 1) Override: While overriding a method in the child class, we should use this
 * annotation to mark that method. This makes code readable and avoid
 * maintenance issues, such as: while changing the method signature of parent
 * class, you must change the signature in child classes (where this annotation
 * is being used) otherwise compiler would throw compilation error. This is
 * difficult to trace when you haven’t used this annotation.
 * 
 * 2) Deprecated: @Deprecated annotation indicates that the marked element
 * (class, method or field) is deprecated and should no longer be used. The
 * compiler generates a warning whenever a program uses a method, class, or
 * field that has already been marked with the @Deprecated annotation. When an
 * element is deprecated, it should also be documented using the
 * Javadoc @deprecated tag, as shown in the following example. Make a note of
 * case difference with @Deprecated and @deprecated. @deprecated is used for
 * documentation purpose.
 * 
 * 3) SupressWarnings: This annotation instructs compiler to ignore specific warnings. 
 * For example in the below code, I am calling a deprecated method 
 * (lets assume that the method deprecatedMethod() is marked with @Deprecated annotation) 
 * so the compiler should generate a warning, however I am using @@SuppressWarnings annotation 
 * that would suppress that deprecation warning.
 */

package AdvancedTopics.MethodAnnotation;

class BuiltInAnnotations {
    /**
     * @deprecated
     */
    @Deprecated
    public void deprecatedMethod() {

    }

    @SuppressWarnings("deprecated")
    public void supressWarnings() {
        deprecatedMethod();
    }

}