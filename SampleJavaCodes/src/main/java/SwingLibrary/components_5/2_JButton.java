package SwingLibrary.components_5;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.awt.*;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * A JButton is also known as a push button or a command button. The user
 * presses or clicks a JButton to perform an action. Typically, it displays text
 * that describes the action it performs when it is clicked. The text is also
 * known as the label.
 * 
 * We can also put an icon in the GUI.
 * 
 * Of course the ActionEvent is the most important (and probably only event)
 * that we listen to.
 * 
 * We can set an action command for key, with a modifier for example. It's
 * called keyboard mnemonic. We usually use a modifier key (alt + C for
 * example). Modifier key is usually platform dependent, but usually is the alt
 *
 * Use alt and c to close in the following program
 */
class JButtonExamples {

    /** Adding an icon */
    public static JButton jbuttonWithIcon() {
        Icon icon = new ImageIcon(JButtonExamples.class.getResource("Eta.png").getPath());
        JButton button = new JButton(icon);
        button.setMnemonic(KeyEvent.VK_C);
        button.addActionListener((e) -> {
            System.exit(0);
        });
        return button;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("JButtons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(1, 3, 20, 20));

        container.add(jbuttonWithIcon());

        frame.pack();
        frame.setVisible(true);
    }

}

/**
 * Let’s take an example where you have a button, say Close, placed in different
 * areas of the window, say different tab pages. If the button is placed four
 * times on a window, and all of them have to look and behave the same, an
 * Action object will help you write the code for the Close button only once and
 * use it at multiple times.
 * 
 * An Action object encapsulates the state and the behavior of a button. You set
 * the text, icon, mnemonic, tool tip text, other properties, and the
 * ActionListener in an Action object, and use the same Action object to create
 * all instance of the JButton. One obvious benefit of doing this is that if you
 * want to enable/disable all four JButtons, you do not need to enable/disable
 * all of them separately. Rather, you set the enabled property in the Action
 * object and it will enable/disable all of them. Let’s extend this usage to the
 * menu item and tool bar. It is common to provide a menu item, a tool bar item,
 * and a button to perform the same action in a window. In such cases, you
 * create all three of them (a menu item, a tool bar item and a button) using
 * the same Action object to keep their states synchronized. Now you can realize
 * the benefits of an Action object is in reusing the code and keeping the state
 * of multiple components synchronized.
 * 
 * Action is an interface. The AbstractAction class provides the default
 * implementation for the Action interface. AbstractAction is an abstract class.
 * You need to inherit your class from it. Listing 2-1 defines a CloseAction
 * inner class, which inherits from the AbstractAction class.
 * 
 * If you want to set any property for the JButton while using the Action
 * object, you can do so by using putValue(String key, Object value) method of
 * the Action interface.
 * 
 * Finally, if a feature of a JButton is set independently after using the
 * action, it DOES NOT affect other buttons (unless we set the feature using the
 * action, which is different of course).
 */

class CloseAction extends AbstractAction {
    private static final long serialVersionUID = -1464749117536207837L;

    public CloseAction(Icon icon) {
        super("Close", icon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

}

class UsingAction {
    public static void main(String[] args) {
        Icon icon = new ImageIcon("");

        CloseAction closeAction = new CloseAction(icon);
        closeAction.putValue(Action.SHORT_DESCRIPTION, "Closes the application");
        closeAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_C);

        JButton button = new JButton(closeAction);
    }
}