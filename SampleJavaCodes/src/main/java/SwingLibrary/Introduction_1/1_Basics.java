package SwingLibrary.Introduction;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * A container is a component that can hold other components inside it. A
 * container at the highest level is called a top-level container. A JFrame, a
 * JDialog, a JWindow, and a JApplet are examples of top-level containers A
 * JPanel is an example of a simple container.
 * 
 * A JButton, a JTextField, etc. are examples of components. In a Swing
 * application, every component must be contained within a container. The
 * container is known as the component’s parent and the component is known as
 * container’s child.
 * 
 * 
 * As we know, the correct way of starting a GUI application is by starting a
 * separate thread using SwingUtilities, and in fact starting the frame as a
 * runnable method.
 * 
 * As we know, when we close a frame, it does not fully exit, it just sets the
 * frame invisible. You can define one of the four behaviors of a JFrame to
 * determine what happens when the JFrame is closed. They are defined in the
 * javax.swing.WindowsConstants interface as four constants. The JFrame class
 * implements the WindowsConstants interface. You can reference all these
 * constants using JFrame.CONSTANT_NAME syntax (or you can use the
 * WindowsConstants.CONSTANT_NAME syntax). The four constants are:
 * 
 * DO_NOTHING_ON_CLOSE: This option does not do anything when the user closes a
 * JFrame. If you set this option for a JFrame, you must provide some other way
 * to exit the application, such as an Exit button or an Exit menu option in the
 * JFrame. (Me: Literally nothing, not even hides the JFrame.)
 * 
 * HIDE_ON_CLOSE: This option just hides a JFrame when the user closes it. This
 * is the default behavior.
 * 
 * DISPOSE_ON_CLOSE: This option hides and disposes of the JFrame when the user
 * closes it. Disposing a JFrame releases any operating system-level resources
 * used by it.
 * 
 * EXIT_ON_CLOSE: This option exits the application. Setting this option works
 * when a JFrame is closed, as if System.exit() has been called. This option
 * should be used with some care. This option will exit the application.
 * 
 * (Me: Question: Why does the program terminate after I set DISPOSE_ON_CLOSE)?
 * 
 * To set size and bounds together, use setBounds. 
 * 
 * Tip: You can position a
 * JFrame in the center by calling its setLocationRelativeTo() method with a
 * null argument.
 */

class SimpleJFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("My Frist Frame");
            frame.setVisible(true);
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frame.setBounds(10, 10, 100, 100);
            frame.setLocationRelativeTo(null);
        });

    }
}