package SwingLibrary.components_5;

import java.awt.Container;
import java.awt.Component;
import javax.swing.JComponent;

/**
 * So every element of swing is component (from java.awt). Then we have
 * containers (again from java.awt) that are children of components. Then we
 * have JComponent which is a child of containers.
 * 
 * The JComponent class inherits from the java.awt.Container class, which in
 * turn inherits from the java.awt.Component class. All swing components inherit
 * from JComponent.
 * 
 * The JComponent class, as a base class for all Swing components, provides the
 * following basic functionalities that are inherited by all Swing components.
 * 
 * • It provides support for tool tips. A tool tip is short text that is
 * displayed when the mouse pointer is paused on a component for a certain
 * period of time.
 * 
 * • It provides support for a pluggable look and feel. All aspects of a
 * component related to how it looks (painting and layout) and how it feels
 * (responding to the user’s interaction with a component such as event
 * handling) is handled by a UI delegate object. Like the JComponent class,
 * ComponentUI in the javax.swing.plaf package is the base class used as a UI
 * delegate object. Each descendant of JComponent uses a different kind of UI
 * delegate object, which is derived from the ComponentUI class. For example, a
 * JButton uses ButtonUI, a JLabel uses LabelUI, and a JToolTip uses ToolTipUI
 * as a UI delegate.
 * 
 * • It provides support for adding a border around a Swing component. The
 * border can be any one of the predefined types (Line, Bevel, Titled, Etched,
 * etc.) or a custom border type.
 * 
 * • It provides support for accessibility. Accessibility of an application is
 * the degree to which it can be used by people with varying abilities and
 * disabilities. For example, it has features that can display text in a bigger
 * font size for vision-impaired users. This book does not cover the Java
 * Accessibility API.
 * 
 * • It provides support for double buffering that facilitates smooth on-screen
 * painting. When a component is erased and painted on-screen, a flicker may
 * occur. To avoid any flickering, it provides an off-screen buffer. The erasing
 * and repainting (updating a component) is done in an off-screen buffer, and
 * the off-screen buffer is copied to on-screen.
 * 
 * • It provides binding of a key on the keyboard to a Swing component. You can
 * bind any key on the keyboard with an ActionListener object to a component.
 * When that key is pressed, the actionPerformed() method of the associated
 * ActionListener is called.
 * 
 * • It provides support for laying out the component when a layout manager is
 * used. It contains methods to get and set the minimum, preferred, and maximum
 * size of a component. The three different type size settings for a JComponent
 * serves as a hint to a layout manager in deciding the size of the JComponent.
 */

class HierArchyOfCompenents {
    public static void main(String[] args) {
        Component component;

        Container container = null;
        System.out.println(container instanceof Component);

        JComponent jcomponent = null;
        System.out.println(jcomponent instanceof Container);
    }
}