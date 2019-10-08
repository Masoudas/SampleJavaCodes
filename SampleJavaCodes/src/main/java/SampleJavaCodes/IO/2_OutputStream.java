package SampleJavaCodes.IO;

import java.io.*;


class OutputStreamer {
    public void byteBasedConsolePrinting() {
        /**
         * As discussed earlier, System.out is a byte oriented console printer.
         * and they are derived from another class called PrintStream (whose base)
         * is OutputStream.
        */

        // The following line is just written to prove the hierarchy of the 
        // classes :D.
        OutputStream oStream = new PrintStream(System.out);

        // Here's something kind of, ok, pay attention. The write(int byteVal) method
        // of the System.out is in fact a byte oriented method. 
        // So even though it takes integers, it writes the low level 8 bits!
        // Moreover, pay attention that whatever is printed out is again turned
        // into ASCII.
        System.out.print("0xFF is printed as:");
        int a = 0xFF;
        System.out.write(a);
        System.out.write('\n');
        
        System.out.print("0xFFFF is printed as:");
        a = 0xFFF;
        System.out.write(a);
        System.out.write('\n');

        String str = "Yo 192";
        
        for (int i = 0; i < str.length(); i++) {
            a = str.charAt(i);    // Just a reminder that no cast is needed here!
            System.out.write(a);
            System.out.write('\n');
        }
    }

    public void charBasedConsolePrinting(){
        /**
         * PrintWriter class is the char based printer. A constructor
         * example is PrintWriter(outputStream out, bool autoFlush). 
         * As expected, an outputStream object should be wrapped into
         * this method.
         * flushingOn controls whether Java flushes the output stream every time a 
         * println( ) method (among others) is called. If flushingOn is true, flushing 
         * automatically takes place. If false, flushing is not automatic.
         */
        PrintWriter printWriter = new PrintWriter(System.out, true);
        printWriter.println("This string is of course prints normally.");

        int x = 'b';
        printWriter.println("When x is printed as int, we get:");
        printWriter.write(x); // Here we change to char before printing, hence, 
                              // we get a bizzare output  
        
        printWriter.println();
        printWriter.println("When x is printed as line, we get: " + x); // Here
        // x is printed as 255, because when we have a complex object (like here)
        // which is not an object format, the toString() method is called.
        double w = 1e-10;
        printWriter.println(w);

    }

    public static void main(String[] args) {
        OutputStreamer oStreamer = new OutputStreamer();
        //oStreamer.ByteBasedConsolePrinting();
        oStreamer.charBasedConsolePrinting();
    }

}