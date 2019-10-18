/**
 * So suppose we want to write some information into multiple files, how
 * do we go about it? Well, we would write open the files and write them.
 * Using ByteArrayStream classes, instead of feeding the string to
 * classes, we create the stream we desire, and then feed it to as many Input/OutStreams as we desire.
 * This outputstream is not necessarily a file!
 * On the other hand, if it's sometimes a byte[], sometimes a file, sometimes a network connection, etc, 
 * then we need some sort of abstraction for "a stream of bytes, and I don't care where they come from." 
 * That's what an InputStream is. When the source happens to be a byte array, ByteArrayInputStream is a good InputStream to use.
 * 
 * There are two classes here:
 * ByteArrayInputStream: This one is used for streaming in several
 * arrays.
 * 
 * ByteArrayOutputStream: This one is used for streaming out an array to
 * possibly several sources.
 */

package SampleJavaCodes.IO.ByteStreams;

import java.io.*;

class ByteArrayInputStreamDemo {
    public static void main(String[] args) {
        
        try (FileInputStream fStream1 = new FileInputStream(
                        "SampleJavaCodes/src/main/java/SampleJavaCodes/IO/SampleText.txt")) {
            byte[] arr = new byte[2048];
            fStream1.read(arr);

            ByteArrayInputStream barray = new ByteArrayInputStream(arr);    // Now we have created
                                    // this array. Note that we normally make ByteArrayInputStream
                                    // the input of a function.
            

        } catch (IOException e) {

        }

    }
}


class ByteArrayOutputStreamDemo {
    public static void main(String[] args) {
        String str = "This string would be written twice to the files" + "without writing any for loops.";

        try (ByteArrayOutputStream barray = new ByteArrayOutputStream();
                FileOutputStream fStream1 = new FileOutputStream(
                        "SampleJavaCodes/src/main/java/SampleJavaCodes/IO/SampleText.txt");
                FileOutputStream fStream2 = new FileOutputStream(
                        "SampleJavaCodes/src/main/java/SampleJavaCodes/IO/OutputByByte.txt")) {
            barray.write(str.getBytes());
            barray.writeTo(fStream1);
            barray.writeTo(fStream2);

        } catch (IOException e) {

        }

    }
}