package SwingLibrary.components_5.ScrollBarComponents_8;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * JScrolPane, is container that can hold nine components, and has its own
 * layout manager, called JScrollPaneLayout. Check out JScrollPane_2.png.
 * 
 * It has two JScrollBars, four corners, a view port, and a header and row
 * column.
 * 
 * The scroll bars, we only need to tell whether they should be there or not.
 * 
 * The view port, is where the scrollable area need to be displayed. a JViewPort
 * component represents the object that is put there, which is simply a wrapper
 * for a component.
 * 
 * The horizontal and vertical headers move with the scroll bar as you move
 * them. They're good for example for showing rulers. We usually don't use these
 * headers.
 * 
 * The corners, that exist when two components meet vertically. The naming C1 to
 * C4 in the figure is just for distinction purpose, and not used in the pane.
 * C1 is created when row header exists and so does column header. C2 when
 * vertical scroll bar exists, and so does the column header, etc. We can add
 * any component to a corner, but not same component to two corners. The
 * component will only be shown if the corner exists.
 * 
 * We also can set a scrollbar policy, for when the scrollbar must appear.
 * Policies are:
 * 
 * 1- Show as needed: It means that a JScrollPane should show the scrollbar when
 * it is needed. A scrollbar is needed when the component in the viewport in a
 * direction, horizontal or vertical, is bigger than its display area. It is up
 * to the JScrollPane to decide when a scrollbar is needed, and if it is needed,
 * it will make the scrollbar visible. Otherwise, it will make the scrollbar
 * invisible
 * 
 * 2- Show always:
 * 
 * 3- Show never:
 * 
 * The scrollbar polices are defined by six constants in the ScrollPaneConstants
 * interface. Three constants are for a vertical scrollbar and three are for a
 * horizontal scrollbar. The JScrollPane class implements the
 * ScrollPaneConstants interface. The constants that define scrollbar policies
 * are XXX_SCROLLBAR_AS_NEEDED, XXX_SCROLLBAR_ALWAYS, and XXX_SCROLLBAR_NEVER
 * 
 * 
 */
class JScrollPaneExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        textArea.setSize(100, 100);

        JScrollPane scrollPane = new JScrollPane(textArea); // Adding the component for viewport.
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // scrollPane.setViewport(viewport); How we put the component.
        scrollPane.setSize(30, 30);

        frame.getContentPane().add(scrollPane);

        frame.pack();

        frame.setVisible(true);

    }

}