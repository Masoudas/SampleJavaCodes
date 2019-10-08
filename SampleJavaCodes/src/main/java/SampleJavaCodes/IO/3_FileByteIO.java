package SampleJavaCodes.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class FileByteIO {
    public void readWriteWithExcplicitClosing() {
        /**
         * The most basic classes FileInputStream and FileOutputStream. These are again
         * derived from InputStream and OutputStream.
         * 
         * Of course we see that if the file does not exist, an exception is thrown
         * called FileNotFoundException.
         * 
         * When an output file is opened, any preexisting file by the same 
         * name is destroyed.
         * 
         * There are two approaches to closing a file. 
         *  1- The standard close() method.
         *  2- try-resource, which is an automatic method.
         */

        // Here, we open the file.
        FileInputStream fStream = null;
        try {
            fStream = new FileInputStream("SampleJavaCodes/src/main/java/SampleJavaCodes/IO/SampleText.txt");
            InputStream iStream = new FileInputStream("SampleJavaCodes/src/main/java/SampleJavaCodes/IO/SampleText.txt"); 
            // Just to prove that this is totally fine as well.
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Now, we try to read the file, which can be done line by line or char by char.
        int data;
        try {
            data = fStream.read();
            while(data != -1){
                System.out.println((char)data);
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
    
}