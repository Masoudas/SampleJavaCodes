/**
 * For the byte-oriented streams, a buffered stream extends a filtered stream class 
 * by attaching a memory buffer to the I/O stream
 * This buffer allows Java to do I/O operations on more than a byte at a time, 
 * thereby improving performance.
 * 
 * The main two classes are BufferedInputStream and BufferedOutputStream.
 * There's also a PushbackInputStream class.
 * 
 * Buffering an input stream also provides the foundation required to support 
 * moving backward in the stream of the available buffer.
 * 
 */

 package SampleJavaCodes.IO.ByteStreams;

import java.io.*;

class BufferedInputStreamDemo{
    public static void main(String[] args) {
        String arr = "This data is read either from a port, file or whatever.";

        ByteArrayInputStream br = new ByteArrayInputStream(arr.getBytes()); // We add this
        // layer of abstraction to indicate that it is in fact an stream.

        BufferedInputStream buffer = new BufferedInputStream(br);

        // Now we can do whatever we want with this stream.


    }
}