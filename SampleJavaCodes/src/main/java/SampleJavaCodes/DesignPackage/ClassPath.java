/* 
To understand the PATH and CLASSPATH, see https://docs.oracle.com/javase/tutorial/essential/environment/paths.html.

The class path is the path that the Java runtime environment searches for classes and other resource files. 
The class path tells JDK tools and applications where to find third-party and user-defined classes -- that is, classes that are not Java extensions or part of the Java platform. 
The class path needs to find any classes you've compiled with the javac compiler -- its default is the current directory to conveniently enable those classes to be found.

The class search path (more commonly known by the shorter name, "class path") 
can be set using either the -classpath option when calling a JDK tool (the preferred method) or by setting the CLASSPATH environment variable. 
The -classpath option is preferred because you can set it individually for each application without affecting other applications and without other applications modifying its value. 


You only need to set the class path when you want to load a class that's (a) not in the current directory or in any of its subdirectories, and (b) not in a location specified by the extensions mechanism.
javac -classpath is used for setting the classpath in javac
java -cp is used for setting the class path for the java environment.

classpath variable could be set as a global variable, although this is not recommended. The global variable name would be CLASSPATH.

Java classes are organized into packages which are mapped to directories in the file system. But, unlike the file system, whenever you specify a package name, you specify the whole package name -- never part of it. For example, the package name for java.awt.Button is always specified as java.awt.

So here's the deal. For the javac command, you specify the classpath in order to indicate where the compiler should look for external classes. In other words, you very likely
don't need to do that. The path can also be given relative to absolute.
In the third example, we tell the compiler to look ~/Downloads for possible classes too. Also note that javac looks for the file and not package,
so don't provide package name!

ABSOLUTE PATH: javac -cp ~/Documents/SampleJavaCodes/ --release 12 ~/Documents/SampleJavaCodes/SampleJavaCodes/src/main/java/SampleJavaCodes/Basics/BasicTypes.java
RELATIVE PATH (to current directory): javac -cp ../ --release 12 ./src/main/java/SampleJavaCodes/Basics/BasicTypes.java
RELATIVE PATH (to current directory): javac -cp ../:~/Downloads --release 12 ./src/main/java/SampleJavaCodes/Basics/BasicTypes.java

AN IMPORTANT issue to remember is that when we provide a classpath, java starts looking for packages INSIDE that folder. Hence, suppose we have
a package named MyPackge inside the folder ~/CodeBase/MyPackage. I must not set the classpath to MyPackage, because the package is not
inside that folder. What I should do in this case is to set classPath to CodeBase rather than classpath. THIS IS VERY IMPORTANT.
Even suppose the case when don't have a package and just a single file. In this case, java assigns a package with no name, however, we should go
one folder before to tell Java to look for that package. So remember, CLASSPATH should be given with respect to package top folder,
not the class file or anything else! For example, in the case of the complicated project here, we may set PWD to or classpath
~/Documents/SampleJavaCodes/SampleJavaCodes/src/main/java and then run the code.




Now to run the codes on the virtual machine, we need to first provide the path the class pathes (for the same purposes as before, also indicating where the 
class we seek to execute is), but to indicate the actual class we seek to execute, we need to go through the package, and then the VM will execute
the main method of that class.

Supposing we are in the root folder of the project:
java SampleJavaCodes.Basics.BasicTypes    // This will do, note how we are calling the class.
ABSOLUTE PATH: java -cp ~/Documents/SampleJavaCodes/SampleJavaCodes/ SampleJavaCodes.Basics.BasicTypes
RELATIVE PATH: java -cp ../ SampleJavaCodes.Basics.BasicTypes

So on and so forth.

NOTE that all of this can be done using the .jar libraries too. The syntax is "java [ <option> ... ] -jar <jar-file-name> [<argument> ...]"
for example  java -Xmx100m -jar /usr/local/acme-example/listuser.jar fred, 
Though to create .jar libraries, one uses maven projects.

*/

