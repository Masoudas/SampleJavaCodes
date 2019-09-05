package SampleJavaCodes.Basics;

/**ja
 * We have:
 * JDK: It is the package that contains the compiler, among other things. 
 * JRE: It is the java runtime environment. 
 * JAVA SE: It means java standard edition.
 * When we type java -version, it gives us the run-time environment and the standard version. Typing javac -version gives us the development kit version.
 * 
 * 
 * The name of the file in java is very important. In java, a source file is a compilation unit.
 * By convention, the name of the main class inside the file must match the filename,
 * 
 * If we type javac Example1.java --release 8, it will generate the .class file.
 * The .class file is the ByteCode, which the Java virtual machine will use. To generate this file, we use the file name,
 * but the .class files that are generated take the name of all the classes that are inside the file,
 
 * Now, when we want to run the program, we type "java Example1" or "java Example11", and we do not add the .class extension.
 * The reason for this is that first java command only runs class files, and second is that 
 * we run a file using java command, we are not actually running the file, we are running the class.
 * Hence, we can write "java Example1" or "java Example11" in the command line and run the corresponding classes.
 
 * It may be the case that some versions of java don't even generate Example11.class, but we still can access the
 * Example11 class from the command line, because it is stored inside of Example1.class file.
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version")); // The version of jdk.
    }
    
}

class Example11 {
    public static void main(String[] args) {        
        for (String s : args) {
            System.out.println("Yo class two! " + s + " and len is " + s.length());
        }
    }
    
}
