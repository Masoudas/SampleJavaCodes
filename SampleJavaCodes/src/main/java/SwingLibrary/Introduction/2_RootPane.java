package SwingLibrary.Introduction;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Think of a JFrame as a picture frame. It has a glass plane (on the top), then
 * you may put several pictures inside the frame (layered pane). The layered
 * pane are showing partially, or the top one and bottom ones are not showing. A
 * layer pane has one content pane, which is the content of the layer (picture).
 * In swing, this content pane for each layer is also one.
 * 
 * rootPane contains several layers and one glass pane (glass on top of layers),
 * layers contain several content.
 * 
 * Officially, When depicting a base java frame, several things happen (See
 * 2_RootPane.png)
 * 
 * 
 * 1- A container, which is called a root pane, is added as the sole child of
 * the JFrame (instance of JRootPane). use getRootPane() method of the JFrame
 * class.
 * 
 * 2- Two containers called glass pane and layered pane are added to the root
 * pane. The glass pane is hidden and it is placed on top of the layered pane.
 * As the name suggests, the glass pane is transparent, and even if you make it
 * visible, you can see through it. The layered pane is named as such because it
 * can hold other containers or components in its different layers. Optionally,
 * a layered pane can hold a menu bar. (use getGlassPane() and getLayeredPane())
 * 
 * 3- A container called a content pane is added to the layered pane. By
 * default, the content pane is empty. This is the container in which you are
 * supposed to add all your Swing components, such as buttons, text fields,
 * labels, etc. Most of the time, you will be working with the content pane of
 * the JFrame. (Use getContentPane()).
 * 
 * 
 * Add components to a container using the add button of that container.
 * 
 * The pack() method, sets the size of the JFrame automatically, so that every component
 * is visible.
 */

class RootPane {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Container contentPane = frame.getContentPane();

        JButton button = new JButton("Ok");

        contentPane.add(button);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

/**
 * Adding two buttons in a normal does not work, and one overtakes the other because
 * default location is set for both of them
 */

class Button {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Container contentPane = frame.getContentPane();

        contentPane.add(new JButton("Ok"));
        contentPane.add(new JButton("Cancel"));

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}