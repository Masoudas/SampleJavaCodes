package SampleJavaCodes.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * The basic point we should keep in mind about Java file byte reader and writer
 * classes is that they read and write in 8-bits. This would imply that we can
 * work with international formats, but who cares!
 */

class FileByteRead {
    public void readWithExcplicitClosingI() {
        /**
         * The most basic classes FileInputStream and FileOutputStream. These are again
         * derived from InputStream and OutputStream.
         * 
         * Of course we see that if the file does not exist, an exception is thrown
         * called FileNotFoundException.
         * 
         * When an output file is opened, any preexisting file by the same name is
         * destroyed.
         * 
         * There are two approaches to closing a file. 1- The standard close() method.
         * 2- try-resource, which is an automatic method. Second method is when we close
         * a file using the try clause.
         */

        // Here, we open the file.
        FileInputStream fStream = null;
        try {
            fStream = new FileInputStream("SampleJavaCodes/src/main/java/SampleJavaCodes/IO/SampleText.txt");

            InputStream iStream = new FileInputStream(
                    "SampleJavaCodes/src/main/java/SampleJavaCodes/IO/SampleText.txt"); // Just to prove that this is
                                                                                        // totally fine as well.

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Now, we try to read the file, which can be done line by line or char by char.
        int data;
        try {
            data = fStream.read();
            while (data != -1) {
                System.out.println((char) data);
                data = fStream.read();
            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            fStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void readWithExcplicitClosingII() {
        /**
         * We can also have the previous method, but catch all exceptions
         * simultaneously, whilst reading the file in the same try clause.
         */

        // Here, we open the file.
        int data;
        FileInputStream fStream = null;
        try {
            fStream = new FileInputStream("SampleJavaCodes/src/main/java/SampleJavaCodes/IO/SampleText.txt");

            data = fStream.read();
            while (data != -1) {
                System.out.println((char) data);
                data = fStream.read();
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            fStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void readWithExplicitClosingIII() {
        /**
         * What we usually want is that no matter what happens, the file should be
         * closed at the end of the day, which is why in the try clause of opening the
         * file, we close it.
         * 
         */
        FileInputStream fStream = null;
        int data = -1;
        try {
            fStream = new FileInputStream("SampleJavaCodes/src/main/java/SampleJavaCodes/IO/SampleText.txt");

            data = fStream.read();
            while (data != -1) {
                System.out.println((char) data);
                data = fStream.read();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            // No matter what happens before, we try and close the file.
            try {
                // Only when fstream is not null do we need to close the stream.
                if (fStream != null) {
                    fStream.close();
                }
            } catch (IOException e) {

                PrintWriter pr = new PrintWriter(System.out); // :D
                pr.println("Yo, we couldn't close the file");
            }
        }
    }

    public void readWithExplicitClosingVI() {
        /**
         * In a more compact manner, because FileNotFoundException is a subclass of the
         * IOException, we can use the same clause for both opening and reading the
         * file. Although if we want to handle each error separately, we should write
         * two clauses.
         */
        FileInputStream fStream = null;
        int data = -1;

        try {
            fStream = new FileInputStream("SampleJavaCodes/src/main/java/SampleJavaCodes/IO/SampleText.txt");

            data = fStream.read();

            while (data != -1) {
                System.out.println((char) data);
                data = fStream.read();
            }

        } catch (IOException e) {
            PrintWriter pr = new PrintWriter(System.out);
            pr.write("I/O exception is: " + e);
        } finally {
            try {
                if (fStream != null)
                    fStream.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void readWithAutomaticClosing() {
        // So we put the resource in the try clause. The resource must implement the
        // AutoClosable class in the java.io library, which Reader and Writer child
        // classes do.

        // Note that the resource variable in this example is final.
        // Also, note that the scope of the resource is limited to the try clause.

        // Again, note the difference with the previous method. We put the resource as
        // an argument for the try clause, hence we don't need to close it. But we catch
        // the exceptions and so forth.
        int data;
        String path = "SampleJavaCodes/src/main/java/SampleJavaCodes/IO/SampleText.txt";
        try (FileInputStream fStream = new FileInputStream(path)) {
        //try (var fStream = new FileInputStream(path)){ // Also, imlplicit type
            // inference is possible.

            data = fStream.read();
            while (data != -1) {
                System.out.println((char) data);
                data = fStream.read();
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        FileByteRead fRead = new FileByteRead();
        fRead.readWithAutomaticClosing();
    }
}

/**
 * In the same manner, we can write to files as well, using FileOutputStream
 * class.
 */

class FileByteWriter {
    void writeWithFinallyClosing() {
        /**
         * Note again that bytes are transfered to ASCII when writing to a file.
         * Question is where in the file do we start to write in? We start writing from
         * the begining.
         * 
         */
        FileOutputStream fStream = null;
        int[] data = { '0', 'A', 'a', 0x01, 0xFF, 0xFFF };

        try {
            fStream = new FileOutputStream("SampleJavaCodes/src/main/java/SampleJavaCodes/IO/OutputByByte.txt");

            for (int var : data) {
                fStream.write(var);
            }

        } catch (IOException e) {
            PrintWriter pr = new PrintWriter(System.out);
            pr.write("I/O message was:" + e);
        } finally {
            if (fStream != null) {
                try {
                    fStream.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }

        }
    }

    public static void main(String[] args) {
        FileByteWriter byteWriter = new FileByteWriter();
        byteWriter.writeWithFinallyClosing();
    }
}