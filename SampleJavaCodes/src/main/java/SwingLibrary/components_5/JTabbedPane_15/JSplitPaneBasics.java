package SwingLibrary.components_5.JTabbedPane_15;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 * With JSplitPane, we can break a container into two parts, each of which can
 * be assigned different components. Once again, we want to think about each
 * split as a frame, hence using a panel inside each.
 */
public class JSplitPaneBasics {
    public static void main(String[] args) {
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        panel1.add(new JLabel("Split1 is here"));
        panel2.add(new JLabel("Split2 is here"));
        
        JSplitPane splitPane = new JSplitPane();
        splitPane.setLeftComponent(panel1);
        splitPane.setRightComponent(panel2);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(splitPane);

        frame.pack();
        frame.setVisible(true);


    }
    
}