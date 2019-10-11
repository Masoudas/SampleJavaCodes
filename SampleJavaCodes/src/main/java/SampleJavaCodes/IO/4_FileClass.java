/**
 * The File class is used for extracting the properties of a file,
 * meaning a file on a disk.
 * 
 * Here's some constructor formats:
 * File f1 = new File("./"); Current working directory
   File f2 = new File("/", "f2"); We add f2 to the cwd
   File f3 = new File(f1, "f2");    We add f2 to the cwd, using the file class.
   File f4 = new File(f1, "f2.txt");    We add f2.txt to the file class. 

   """ Use the . to create in the relative path of the project.

   Here's something interesting, a folder is just another file with the name of 
   files inside of it!
 */

package SampleJavaCodes.IO; 
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;

class ManipulateFiles {
    public void createFile(){   
        // We create the file, either with or without type.
        // If file alreay exists, returns false.
        File f1 = new File("./SampleJavaCodes", "f1"); // No path
        File f2 = new File("./", "f2.txt");

        try {
            System.out.println(f1.createNewFile());
            System.out.println(f2.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void generalMethods() {
        File f1 = new File("./SampleJavaCodes");
        p("The total resolved path is: " +f1.getPath());
        p("Exists:" + f1.exists());
        p("Absolute path: " + f1.getAbsolutePath());
        p("File names: " + f1.getName());
        p("get parent directory: " + f1.getParent());
        p("Is file:" + f1.isFile());    // There are particular things that can not be files.
        p("Can read: " + f1.canRead()); // Do we have read permission?
        p("Can write: " + f1.canWrite());   // Sure

        // p("The length of the file is " + f1.length() + "Bytes");

        p("How much space is left in this partition:" + f1.getUsableSpace() + " Bytes");
        p("How much space is left in this partition:" + f1.getUsableSpace()/1024/1024/1024 + " GB");

        // Listing the files in a directory as string.
        String[] str = f1.list();
        for (String str1 : str) {
            p("Files and folders inside the folder: " + str1);    
        }      

        // The following method does the same, but returns an array of File classes
        // rather than strings.
        File[] files = f1.listFiles(); // There are overloads for filtering as well.
        for (File file : files) {
            p("Files and folders inside the folder using the Files array: " + file.getName());    
        }      

        f1.toPath();    // Returns a Path object, which is part of the NIO library.
    }

    private void utilityMethods(){
        File f = new File("./", "file.txt");
        File f1 = new File("./", "renamedFile.txt");
        
        try {
            f.createNewFile();
        } catch (IOException e) {
        }

        boolean nameChanged = false;
        nameChanged = f.renameTo(f1);
        if (nameChanged){
            p("File name has changed.");
        }

        boolean fileDeleted = false;
        fileDeleted = f1.delete();
        if (fileDeleted){
            p("File was deleted.");
        }

        // We can create a folder using the mkdir method.
        // This method creates the folder if the entire path exists.
        // To make the folders for the entire path, we use mkdirs().
        boolean folderCreated;
        File f2 = new File("./");
        File f3 = new File(f2, "TempFolder");   // Just to give an idea of how we add stuff.
        folderCreated = f3.mkdir(); 
        f3.delete();
        
        PrintWriter pr = new PrintWriter(System.out);
        pr.println(folderCreated);

        // folderCreated = f1.mkdirs(); This creates all the folders along the path
        // if they don't exist.

    }

    private void FilterFileNames(){
        // We want to filter files when listing them.
        File f1 = new File("./SampleJavaCodes/src/main/java/SampleJavaCodes/Basics");

        if (!f1.exists()) return;
        
        FilenameFilter filter = new FilterExtension("java");    // The FilenameFilter is
                // an interface. FilterExtension is a class implemented below here, by me :D!
        String[] str = f1.list(filter);
        for (String str1 : str) {
            p("Files inside the folder: " + str1);    
        }


    }

    public static void main(String[] args) {
        ManipulateFiles mFiles = new ManipulateFiles();
        //mFiles.createFile();

        mFiles.generalMethods();
        mFiles.utilityMethods();
        mFiles.FilterFileNames();
    }

    static void p(String str){
        System.out.println(str);
    }
}

class FilterExtension implements FilenameFilter{
    // The implementation of the interface that filters files.
    // We use it to filter the desired file extension.

    String extension;
    public FilterExtension(String extension){
        this.extension = extension;
    }
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith("." + this.extension);
    }
    
}