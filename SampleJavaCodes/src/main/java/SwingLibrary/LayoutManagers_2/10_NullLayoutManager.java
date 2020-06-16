package SwingLibrary.LayoutManagers;

/**
 * We know that the default layout manager of a container is the border layout, and
 * not null. We may set the layout manager to null, so that there's no layout manager.
 * However, because the job of manager is to set size and position of a component,
 * setting it to none means this would not be done automatically, and in different
 * platforms the components may not even show!
 */

import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JButton;

/**
 * This example fully shows why we need layout managers to set the position and
 * size of a component in a container.
 */
class NullLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Null Layout Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(null);
        JButton b1 = new JButton("Small Button 1");
        JButton b2 = new JButton("Big Big Big Button 2...");
        contentPane.add(b1);
        contentPane.add(b2);
        // Must set (x, y) and (width, height) of components
        b1.setBounds(10, 10, 100, 20);
        b2.setBounds(120, 10, 150, 20);

        frame.setVisible(true);
    }
}