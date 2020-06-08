package SwingLibrary.Introduction;

/**
 * Border layout has five locations, north, west, south, east, center.
 * When adding components, you need to specify location in layout manager.
 * 
 * The default layout for the content pane of a JFrame is a BorderLayout
 * 
 * You can add at most one component to one area of a BorderLayout. Of course to add more,
 * we can add a container to one area and then add components inside of it.
 * 
 * We can use constants PAGE_START, PAGE_END, LINE_START, and LINE_END. The PAGE_START and PAGE_END
 * NORTH and SOUTH. The LINE_START and LINE_END depend on the orientation of the
 * frame (left to right or right to left), and are essentially like EAST and WEST then.
 * 
 * So the reason why adding several buttons like in the 3_LayoutManagers did not work is that
 * we were overriding the component added to the center all the time! But we know only one can be added!
 * 
 * How does a BorderLayout compute the size of the components? It computes the size 
 * of the components based on the area in which they are placed. 
 * It respects the preferred height of the component in north and south. 
 * However, it stretches the component’s width horizontally according to 
 * the available space in north and south. That is, it does not 
 * respect the preferred width of the components in north and south. 
 * It respects the preferred width of the components in east and west and gives 
 * them height necessary to fill the entire space vertically. 
 * The component in the center area is stretched horizontally as well as vertically 
 * to fit the available space. That is, the center area does not respect its 
 * component’s preferred width and height  */

import javax.swing.JButton;
import java.awt.Container;
import javax.swing.JFrame;
import java.awt.BorderLayout;

class BorderLayoutTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BorderLayout Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = frame.getContentPane();
        // Add a button to each of the five areas of the BorderLayout
        container.add(new JButton("North"), BorderLayout.NORTH);
        container.add(new JButton("South"), BorderLayout.SOUTH);
        container.add(new JButton("East"), BorderLayout.EAST);
        container.add(new JButton("West"), BorderLayout.WEST);
        container.add(new JButton("Center"), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}