/**
 * As we already know, FileReader and FileWriter classes
 * can be used to read and write chars (in unicode, don't forget).
 * 
 * Again, don't forget that the read method returns integers,
 * but these are chars rather than bytes.
 */

package SampleJavaCodes.IO.CharStreams;

import java.io.File;
import java.io.FileReader;

class FileReaderDemo{
    public static void main(String[] args) {
        File file = new File("./SampleJavaCodes/src/main/java/SampleJavaCodes/IO", "SampleText.txt");
        try (FileReader frReader = new FileReader(file)) {
            int c = frReader.read();
            while(c!= -1) {
                c = frReader.read();
                System.out.println((char)c);
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}