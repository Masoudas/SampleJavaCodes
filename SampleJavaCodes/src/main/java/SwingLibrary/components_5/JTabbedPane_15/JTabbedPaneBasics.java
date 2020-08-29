package SwingLibrary.components_5.JTabbedPane_15;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * With tabbed panes, we can have multi-tab frames. We should think of each tab
 * as a frame, rather than a panel. Hence, with each tab we want to put another
 * panel.
 */
class JTabbedPaneExample {
    public static void main(String[] args) {
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        panel1.add(new JLabel("Panel1 is here"));
        panel2.add(new JLabel("Panel2 is here"));

        JTabbedPane pane = new JTabbedPane();
        pane.addTab("Panel1", panel1);
        pane.addTab("Panel2", panel2);      

        Component panel1FromTabbedPane = pane.getTabComponentAt(0);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(pane);

        frame.pack();
        frame.setVisible(true);

    }
}