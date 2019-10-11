/**
 * As we already know, this method is used for streaming a
 * byte stream.
 * As we know, this class is ABSTRACT. Here are some of the interesting features:
 * There's a buffer size involved here, which by default is DEFAULT_BUFFER_SIZE=8192.
 * 
 * There are some methods here:
 * mark(): Marks the current point in the buffer, so that we can reset to it!!!
 * reset(): Resets back to this point, so that we can start reading!
 * 
 */

package SampleJavaCodes.IO;
import java.io.InputStream;

class InputStreamFeatures{
    public static void main(String[] args) {
        InputStream iStream;
    }
}