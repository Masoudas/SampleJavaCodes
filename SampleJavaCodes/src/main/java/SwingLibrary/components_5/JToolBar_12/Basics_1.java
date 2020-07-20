package SwingLibrary.components_5.JToolBar_12;

import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

/**
 * A toolbar provides a set of common actions using buttons for the user. It
 * comes alongside a menu.
 * 
 * An object of the JToolBar class represents a toolbar. It acts as a container
 * for the toolbar buttons. It is a little smarter container than other
 * containers such as a JPanel. It can be moved around at runtime. It can be
 * floatable. If it is floatable, it displays a handle that you can use to move
 * it around. You can also use the handle to pop it out in a separate window.
 * 
 * The buttons in a toolbar need to be smaller in size than usual buttons. You
 * make a JButton smaller in size by setting its margin to zero. You should also
 * add a tool tip to each toolbar button to give a quick hint to the user about
 * its usage.
 * 
 * The setFloatable() method allows the JToolbar to float around, separately
 * from the frame.
 * 
 * The setRollover(boolean rollOver) allows you to draw the borders of the
 * toolbar only when you hover over it.
 */
public class Basics_1 {
    public static void main(String[] args) {
        // Create a horizontal JToolBar
        JToolBar toolBar = new JToolBar();

        // Create a horizontal JToolBar with a title. The title is
        // displayed as a window title, when it floats in a separate window.
        JToolBar toolBarWithTitle = new JToolBar("My ToolBar Title");

        // Create a Vertical toolbar
        JToolBar vToolBar = new JToolBar(JToolBar.VERTICAL);

        // Create a button for the toolbar
        JButton newButton = new JButton("New");

        // Set the margins to 0 to make the button smaller
        newButton.setMargin(new Insets(0, 0, 0, 0));

        // Set a tooltip for the button
        newButton.setToolTipText("Add a new policy");

        // Add the New button to the toolbar
        toolBar.add(newButton);
        toolBar.setFloatable(true);
        toolBar.setRollover(false);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(toolBar);

        frame.pack();
        frame.setVisible(true);

    }
}