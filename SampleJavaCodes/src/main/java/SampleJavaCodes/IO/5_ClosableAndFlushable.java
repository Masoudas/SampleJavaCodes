/**
 * 
 * Closable interface extends the Autoclosable interface (try loop, remember?). Hence, 
 * classes that implement this method can be closed automatically.
 * 
 * Flushable interface can force the buffered output to be written
 * to the stream to which the object is attached. They define a method
 * called flush().
 * So for example in the PrintWriter class, the autoFlushingOn parameter controls whether the output buffer is 
 * automatically flushed every time a newline (\n) character or a byte array is 
 * written or when println( ) is called.
 * 
 * This flusing business seems complicated. Let's just skip it for now,.
 */

package SampleJavaCodes.IO;

import java.io.PrintStream;

class FlushOnExample{
    public static void main(String[] args) {
        PrintStream pr = new PrintStream(System.out, true);

        char[] buff = {'a', 'b', '\n', 'c', 'd', '\n'};
        for (int i = 0; i < 6; i++){
            pr.write(buff[i]);
        }


    }

}