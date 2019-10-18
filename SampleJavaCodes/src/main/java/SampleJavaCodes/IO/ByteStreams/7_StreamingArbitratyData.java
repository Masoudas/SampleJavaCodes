/**
 * Here's an important question:
 * Suppose we want to write some float point or an integer 
 * inside a file. How do we go about it?
 * 
 * Well, casting back to bytes is too complicated. Hence we use
 * DataInputStream and DataOutputStream. These babies can take care of
 * any given data for us.
 * 
 * Of course writing seems ok, but what happens when they try to read data?
 * Say for example a double precision data or what not? Well, the way the data
 * is written allows you to. It's kind of bizzare I have to say!
 */

package SampleJavaCodes.IO.ByteStreams;
import java.io.*;

class DataStreamExamples{
    public static void main(String[] args) {
        // Writing to a file.

        // The same thing would happen if we tried to write in a .txt file.
        try (DataOutputStream dStream = new DataOutputStream(
            new FileOutputStream("SampleJavaCodes/src/main/java/SampleJavaCodes/IO/DoubleData.dat"))){
            int space = '\n';
            dStream.writeDouble(5.7552);
            dStream.writeChar(space);
            dStream.writeDouble(8.131455552);
            dStream.writeChar(space);    
            
        } catch (IOException e) {
            
        }
    }

}