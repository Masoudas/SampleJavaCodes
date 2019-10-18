/**
 * The FileOutputStream is used for writing to files byte wise.
 * If the file is not present, it will create it. If the space
 * is readonly, it throws an IOException. If already exists,
 * overwrites it.
 * 
 * 
 * To skip the lines (go to the next line), we may use '\n'
 */

package SampleJavaCodes.IO.ByteStreams;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class FileOutputStreamExample {
    public static void main(String[] args) {
        String str1 = "This is line one, we end it with backslash to go to next \n";
        String str2 = "This would be a new line";

        byte[] arr1 = str1.getBytes(); 
        byte[] arr2 = str2.getBytes(); 

        File file = new File("./", "Streamed.txt");
         
        try (FileOutputStream fstream = new FileOutputStream(file)){
            fstream.write(arr1);
            fstream.write(arr2, 4, 10);

            for (int i = 14; i <22; i++) fstream.write(arr2[i]);

        } catch (IOException e){
            System.out.println(e);
        }
        
    }
    
}