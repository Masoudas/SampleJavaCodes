package SwingLibrary.Introduction;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Adding two buttons in a normal window does not work, and one overtakes the
 * other because default location is set for both of them. This is why we need
 * LayoutManagers. A layout manager is simply a Java object whose sole job is to
 * determine the position and size of components within a container.
 * 
 * The default manager is called BorderLayout.
 * 
 * Tip: A component can be added to only one container at one time. If you add
 * the same component to another container, the component is removed from the
 * first container and added to the second one.
 */

class TwoButton {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Container contentPane = frame.getContentPane();

        contentPane.add(new JButton("Ok"));
        contentPane.add(new JButton("Cancel"));

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Component[] comps = contentPane.getComponents();
        // Display how many components the content pane has
        System.out.println("Content Pane has " + comps.length + " components.");

    }

}