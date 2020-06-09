package SwingLibrary.LayoutManagers;

import java.awt.Container;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The job of a layout manager is to compute four properties (x, y, width, and
 * height) of all components in a container. We normally want to add layout
 * manager to the content pane.
 * 
 * The point of a layout manager is that when the component is resize, the
 * layout remains sensible. Otherwise, we get issues. So just setting the
 * location of components does not suffice.
 * 
 * Also, layout manager determines the correct size for a component. Suppose a
 * button has text in different languages. It needs different sizes, moreover
 * different machines render it differently,
 * 
 * Famous layout managers are:
 * 
 * • FlowLayout • BorderLayout • CardLayout • BoxLayout • GridLayout •
 * GridBagLayout • GroupLayout • SpringLayout
 * 
 * The default layout manager is the BodrderLayout for JFrame.
 * 
 * Starting from Java 5, the calls to add() and setLayout() methods on a JFrame
 * are forwarded to its content pane. That is, from Java 5, the two calls
 * frame.setLayout() and frame.add() will do the same as calling
 * frame.getContentPane().setLayout() and frame.getContentPane().add(). It is
 * very important to note that the getLayout() method of a JFrame returns the
 * layout manager of the JFrame and not its content pane. In summary, always get
 * the content pane first, and then get or set it's layout manager.
 * 
 */

class LayoutManagers {
    public static void main(String[] args) {
        // Set FlowLayout as the layout manager for the content pane of a JFrame
        JFrame frame = new JFrame("Test Frame");
        Container contentPane = frame.getContentPane(); // As we recall, this is the content of the layer pane of root
                                                        // pane.
        contentPane.setLayout(new FlowLayout());

        // Set BorderLayout as the layout manager for a JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Get the layout manager for a container
        LayoutManager layoutManager = contentPane.getLayout();
    }

}