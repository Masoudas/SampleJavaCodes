package SwingLibrary.components_5.JMenu;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Provides a compact space for presenting several actions.
 * 
 * We create a JMenubar. Then we need to add a list of options to it. The JMenu
 * is like the top level menu (File, Edit, Selection ...).
 * 
 * The JMenuItem adds options to a JMenu.
 * 
 * If we want an option to have items, instead of defining it as a JMenuItem, we
 * define it as a JMenu, like the save menu here.
 * 
 * To add event listener, we want to add actionListener to the JMenuItems.
 * 
 * We can make items or menus visible or not using setVisible.
 * 
 * We can assign shortcuts to menus using setMneumic(). Note that the menu item
 * must be visible for the shortcut key to work. This means to actually open the
 * menu under which the item exists. To just make it work without having to
 * actually open the menu, we can use setAccelerator() method.
 * 
 * Finaly, note that JMenuBar is just a container with a BoxLayout, and JMenu
 * and JMenuItem are just JButtons.
 * 
 */
public class Basics_1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");

        JMenuItem file_open = new JMenuItem("open");
        JMenu file_save = new JMenu("save");
        JMenuItem file_exit = new JMenuItem("exit");

        JMenuItem save_png = new JMenuItem("savePNG");
        JMenuItem save_svg = new JMenuItem("saveSVG");

        save_png.addActionListener(l -> System.out.println("Saving png"));
        file_exit.addActionListener(l -> System.exit(0));

        file_save.add(save_png);
        file_save.add(save_svg);

        file.add(file_open);
        file.add(file_save);
        file.addSeparator(); // The separator item we talked about
        file.add(file_exit);

        menuBar.add(file);
        menuBar.add(edit);

        // Method to add the menu bar.
        frame.setJMenuBar(menuBar);

        frame.pack();
        frame.setVisible(true);
    }
}