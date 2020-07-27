package SwingLibrary.components_5.JFileChooser_17;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Allows you to choose a file from the file system. An instance can be reused,
 * and will always remember the last place it had been.
 * 
 * We can customize it to only choose files, or only directories, or both.
 * Should it let the user choose multiple files? apply a file filter criteria to
 * show files based on your criteria
 * 
 * We use one of showOpenDialog(), showSaveDialog(), or showDialog(), to display
 * File chooser in a JDialog. All the three methods of the JFileChooser class
 * accept a Component argument. It is used as the owner for the JDialog it
 * displays and for centering the dialog box. Pass null as its parent component
 * to center it on the screen.
 * 
 * Check for the return value, which is an int, from the method call in the
 * previous step. If it returns JFileChooser.APPROVE_OPTION, the user made a
 * selection. The other two possible return values are
 * JFileChooser.CANCEL_OPTION and JFileChooser.ERROR_OPTION, which indicate that
 * either user cancelled the dialog box or some kind of error occurred. To get
 * the selected file, call the getSelectedFile() or getSelectedFiles() method,
 * which returns a File object and a File array, respectively. Note that a
 * JFileChooser component only lets you select a file from a file system.
 * 
 * You can specify the initial directory in its constructor or using its
 * setCurrentDirectory() method.
 * 
 * The funny thing is that file chooser gets a hold of the thread, and does not
 * let anything happen until we choose a file, which is why we need no event
 * handling to get the file choosen, like the code below.
 */
class FolderChooser {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser("/");

        // Only directories are allowed now.
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        // Don't allow multi file selection.
        fileChooser.setMultiSelectionEnabled(false);

        // To show the dialog as a "File Open" dialog.
        // showSaveDialog would have shown it as a save dialog.
        // We can change the title using setDialogTitle. Also, the approve button (open
        // in this case), name can be set using setApproveButtonText().
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("You selected: " + selectedFile);
        }

    }
}

/**
 * The setFileFilter allows you to set a file filter. We want to inherit from
 * FileFilter abstrat class.
 * 
 * There's a FileNameExtensionFilter that allows you to filter based on file
 * extension.
 * 
 * Note that a file extension is the part of the file name after the last dot.
 * If a file name does not have a dot in its name, it does not have an
 * extension. After you create an object of the FileNameExtensionFilter class,
 * you need to call the addChoosableFileFilter() method of the JFileChooser to
 * set a filter.
 * 
 * To disable all file filter, we need to disable its filter using
 * setAcceptAllFileFilterUsed
 */

class SettingFilter {
    public static void main(String[] args) {
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", ".txt");
        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter(filter);

        // Disable "accept all files filter"
        chooser.setAcceptAllFileFilterUsed(false);

        chooser.showOpenDialog(null);
    }
}