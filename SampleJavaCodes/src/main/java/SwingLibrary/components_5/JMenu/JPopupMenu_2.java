package SwingLibrary.components_5.JMenu;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JScrollPane;

/**
 * Now, JPopupMenu is exactly like the JMenuBar. The only difference is that it
 * appears where we desire to see a menu on the screen (like when you right
 * click and see a menu). We can set the menu to appear on click, or on release.
 * 
 * The show method is used for showing the popup.
 * 
 * We typically want to show the popup using right click, either on click or
 * release.
 */
public class JPopupMenu_2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPopupMenu popupMenu = new JPopupMenu();

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");

        popupMenu.add(file);
        popupMenu.add(edit);

        frame.setVisible(true);
        popupMenu.show(frame, 80, 80);

    }

}

// Create a mouse listener
class MouseEventListener extends MouseAdapter {
    public MouseEventListener(JP){

    }
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.isPopupTrigger()) {
            popupMenu.show(e.getComponent(), e.getX(), e.getY());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.isPopupTrigger()) {
            popupMenu.show(e.getComponent(), e.getX(), e.getY());
        }
    }
};