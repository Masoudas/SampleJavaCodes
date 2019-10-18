/** 
 * Scanner class can be used to read a file line by line.
 */

package SampleJavaCodes.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ScannerClassDemo {
    public static void main(String[] args) {
        // Clearly one issue with this baby is that it does not buffer the input,
        // Hence, it may read all the file together, assuming there's no \n present.
        File file = new File("./SampleJavaCodes/src/main/java/SampleJavaCodes/IO", "SampleText.txt");
        try (Scanner scr = new Scanner(file)){
            while(scr.hasNextLine()){
                System.out.println(scr.nextLine());
            }
            
        } catch (FileNotFoundException e) {
        }



    }
}