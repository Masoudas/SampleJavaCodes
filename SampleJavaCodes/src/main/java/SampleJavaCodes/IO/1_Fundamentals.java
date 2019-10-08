/**
 * By a stream we mean an abstraction that either produces or consumes
 * information. What this means is that we treat the info produced by the
 * keyword, hard disk, or any other machine the same way.
 * 
 * Java defines two types of streams: byte and character 
 * Byte streams provide a convenient means for handling input and output 
 * of bytes. Byte streams are used, for example, when reading or writing 
 * binary data.
 *.Main classes: InputStream and OutputStream 
 * abstract classes have methods read() and write() that can be used.
 * As an example, System.out and System.in methods both are derived 
 * from the InputStream and OutputStream
 * 
 * Character streams provide a convenient means for handling input and 
 * output of characters. They use Unicode and, therefore, can be 
 * internationalized. Character streams are normally better in terms 
 * of performance and such. But at the lowest level, all I/O is still byte-oriented
 * Main classes: InputStreamReader, OutputStreamReader, BufferReader, BufferedWriter
 *
 * 
 * Reader and Writer are the two abstract classes at the top
 * of the hierarchy of these classes.
  *  
 * 
 * As we know, all Java programs automatically import the java.lang package.
 * The System class in lang encapsulates several aspects 
 * of the run-time environment. For example, using some of its methods, you can 
 * obtain the current time and the settings of various properties associated with 
 * the system. System also contains three predefined stream variables: in, out, 
 * and err. These fields are declared as public, static, and final within System. 
 * This means that they can be used by any other part of your program and without 
 * reference to a specific System object
 * 
 * System.out refers to the standard output stream. By default, this is the 
 * console (this is why we use system.out.println()). System.in refers to standard input, 
 * which is the keyboard by default. 
 * System.err refers to the standard error stream, which also is the console by 
 * default. However, these streams may be redirected to any compatible I/O 
 * device. System.in is an object of type InputStream; System.out and System.err 
 * are objects of type PrintStream
 * 
 * System.in is an example of a byte reader. However, we can wrap this class into
 * a character reader, which is commercially used and is easier to maintain.
 * See the following example:
 */

package SampleJavaCodes.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

class SystemUse {
    public static void main(String[] args) {
        // To create a character console reader, we need to wrap System.in
        // in a BufferedReader, where BufferReader(Reader inputReader).
        // inputReader is the stream that is linked to the instance of
        // BufferedReader that is being created

        // One of its concrete subclasses is InputStreamReader, which converts bytes to
        // characters. It has the constructor InputStreamReader(InputStream
        // inputStream).

        // This is the documentation of the InputStreamReader:
        // An InputStreamReader is a bridge from byte streams to character streams:
        // It reads bytes and decodes them into characters using a specified charset.
        // The charset that it uses may be specified by name or may be given explicitly,
        // or the platform's default charset may be accepted. Each invocation of one of
        // an
        // InputStreamReader's read() methods may cause one or more bytes to be read
        // from
        // the underlying byte-input stream. To enable the efficient conversion of bytes
        // to characters,
        // more bytes may be read ahead from the underlying stream than are necessary to
        // satisfy
        // the current read operation. For top efficiency, consider wrapping an
        // InputStreamReader
        // within a BufferedReader. like we do in the following example.
        // Note Also that we can define the char set in which the file is being read,
        // in the InputStreamReader(inputStream, charset);
        InputStreamReader iStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(iStreamReader);
        
        // Note that this program does not reads chars, until we press enter
        // This is because System.in is line buffered, by default. This means that no
        // input is actually
        // passed to the program until you press enter
        char c = 0;
        System.out.println("Enter char till q");
        do {
            try {
                c = (char) br.read(); // We read a char as integer. At the end of line it returns -1.
                System.out.println(c);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } while (c != 'q');
        
        SystemUse sUse = new SystemUse();
        sUse.readFileExample();

        sUse.readByString();
      
    }

    void readByString(){
        // In this example we read Strings from the command line.
        InputStreamReader istream = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(istream);

        String str = null;
        do {
            try {
                str = br.readLine();
                System.out.println(str);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } while(!str.equals("Stop"));
        // while (str != "Stop"); Nobody compares string like this remember!

    }

    void readFileExample(){
                // As another example, We can define a file reader, which is a byte reader,
        // because
        // it's derived from the inputStream class of course!
        InputStream iStream;
        try {
            iStream = new FileInputStream("SampleJavaCodes/src/main/java/SampleJavaCodes/IO/SampleText.txt");
            InputStreamReader iReader = new InputStreamReader(iStream); // Now we wrapped it, 
                                                    // and it's gonna be char reader.
            // Also as mentioned, we wrap this in a buffer, but this is just for effiviency.
            BufferedReader buffer = new BufferedReader(iReader); // Now this baby actually
            // gives out stuff char by char.
            
            /**
             * We can read the data line by line.
                String str = null;
                do {
                    try {
                        str = buffer.readLine();
                        System.out.println(str);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                
                } while(str != null);         
             * 
             */
            // Or, we can try reading char by char.
            int data;
            try {
                data = buffer.read();
                while(data != -1){
                    System.out.println((char)data);
                    data = buffer.read();
                }
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
    
    
            
            try {
                buffer.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}