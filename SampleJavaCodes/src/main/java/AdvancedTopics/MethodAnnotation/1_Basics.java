/**
 * See https://beginnersbook.com/2014/09/java-annotations/
 * 
 * Java Annotations allow us to add metadata information into our source code,
 * although they are not a part of the program itself. Annotations were added to
 * the java from JDK 5. Annotation has no direct effect on the operation of the
 * code they annotate (i.e. it does not affect the execution of the program).
 * (example, override).
 * 
 * Why use annotation: 1) Instructions to the compiler: There are three built-in
 * annotations available in Java (@Deprecated, @Override & @SuppressWarnings)
 * that can be used for giving certain instructions to the compiler. For example
 * the @override annotation is used for instructing compiler that the annotated
 * method is overriding the method.
 * 
 * 2) Compile-time instructors: Annotations can provide compile-time
 * instructions to the compiler that can be further used by sofware build tools
 * for generating code, XML files etc.
 * 
 * 3) Runtime instructions: We can define annotations to be available at runtime
 * which we can access using java reflection and can be used to give
 * instructions to the program at runtime.
 * 
 * An annotation always starts with @. Annotations can be applied to classes,
 * interfaces, methods and fields.
 * 
 * 
 */