package SwingLibrary.LayoutManagers;

/**
 * Laysout components IN A CONTAINTER either horizontally in one row or
 * vertically in one column.
 * 
 * To use it:
 * 
 * 1- Create a JPanel first.
 * 
 * 2- Create box layout, where you need to pass the container together with the
 * layout type to the object when constructing it. X_AXIS, Y_AXIS are trivial.
 * LINE_AXIS and PAGE_AXIS are similair to X_AXIS, Y_AXIS, however, they use the
 * alignment of the container to draw.
 * 
 * Gives largest height of components to the elements in the horizontal, and
 * largest width in vertical to all components.
 * 
 * We also have a Box in javax.swing, that is a container that uses a box layout
 * by default.
 * 
 * The Box class also allows you to create invisible components and add them to a box, 
 * so you can adjust spacing between two components. It provides four types of invisible components:
 * Glue, Strut, Rigid Area, Filler.
 * 
 * A glue is an invisible, expandable component. You can create horizontal and vertical glues using the 
 * createHorizontalGlue() and createVerticalGlue() static methods of the Box class.
 * 
 * Box hBox = Box.createHorizontalBox(); 
 * hBox.add(new JButton("First")); 
 * hBox.add(Box.createHorizontalGlue()); 
 * hBox.add(new JButton("Last"));
 * 
 * A strut is an invisible component of a fixed width or a fixed height. 
 * You can create a horizontal strut using the createHorizontalStrut() method 
 * that takes the width in pixels as an argument.
 * 
 * A rigid area is an invisible component that is always the same size. 
 * You can create a rigid area by using the createRigidArea().
 * 
 * A filler is an invisible custom component that you can create by specifying 
 * your own minimum, maximum, and preferred sizes.
 */

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;

class BoxLayoutTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BoxLayout Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        JPanel hPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(hPanel, BoxLayout.X_AXIS);
        hPanel.setLayout(boxLayout);
        for (int i = 1; i <= 3; i++) {
            hPanel.add(new JButton("Button " + i));
        }
        contentPane.add(hPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}