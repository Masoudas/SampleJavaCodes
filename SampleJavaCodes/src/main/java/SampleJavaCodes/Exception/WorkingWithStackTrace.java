package SampleJavaCodes.Exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class WorkingWithStackTrace {
    // We can print a stack directly to file.
    public static void printStreamToFile() throws FileNotFoundException {
        PrintStream stream = new PrintStream(new File(
                "./SampleJavaCodes/src/main/java/SampleJavaCodes/Exception/StackStream.txt"));

        new Exception().printStackTrace(stream);

    }

    // We can also access the stack trace in the program.
    public static void accessToStackTrace() {
        StackTraceElement[] elements = new Exception().getStackTrace();

        for (StackTraceElement stackTraceElement : elements) {
            System.out.println("Print stack " + stackTraceElement);
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        printStreamToFile();
        accessToStackTrace();
    }

}