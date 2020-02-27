/* To create a package, simply put the package command on top of the source file name. 
The package and the directory must be the same, for example for package a.b.c, 
the directories are a/b/c, and here in the c directory we can put several class files.

As discussed before, where does Java look for the packages we say we want?
First, by default, the Java run-time system uses the current working directory as its starting point. Thus, if your package is in a
subdirectory of the current directory, it will be found. Second, you can specify a directory path or paths by setting the CLASSPATH environmental variable.
Third, you can use the -classpath option with java and javac to specify the path to your classes.

Hence for example for the program to find a package called myPackage, the program can be executed from a folder on top of my package,
or be given to the CLASSPATH variable. For this discussion, refer to the classpath discussion.

Question is what happens to a class if it is declared public or private (only two options)? and what would happen to the
members of that class?

1- Private class can only be accessed by classes in the same package. By package we mean also the subpackage the class is put inside of too.
        To make a class private, we do not put any modifiers behind it.
        For example, Example11 class inside of basics folder can be accessed by all the classes inside of that package, but not for example 
        by the Classes subpackage.
2- Public class of course can be accessed anywhere. Check TestPackage to see that this in fact is the case.

For the members:
1- Private can never be accessed outside the class.
2- Protected is accessed by every class inside the same package.
3- Public can always be accessed.

Finally, note that java.lang package is imported in all java source files, as import java.lang.*, which means every class and 
subpackge inside of java.lang.

Note that the whole fuss about making classes private or members protected is only for the sake of packaging and compilation.
After compilation and having the machine codes, we can all the private classes inside of a package from command line no questions asked.
*/
