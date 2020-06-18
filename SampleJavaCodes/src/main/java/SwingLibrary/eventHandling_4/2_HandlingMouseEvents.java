package SwingLibrary.eventHandling_4;

/**
 * Mouse events cannot be passed lambdas (at least for JButtons). They consist
 * of: entered, exited, clicked, pressed, released. Difference between clicked
 * and pressed? (I think click can happen with any mouse key, whereas pressed
 * happens with action key).
 * 
 * MouseListener interface is the interface to implement.
 * 
 * MouseEvent class itself has many methods, like get number of clicks, getX and
 * getY that return the position with respect to component boundary, and
 * getXonScreen and getYonScreen with respect to screen.
 * 
 * Don't forget that there are adaptor class that can be used to override only
 * the desired methods. Like MouseAdaptor class for example.
 */
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

class HandlingMouseEvent extends JFrame {
    private static final long serialVersionUID = -5112002696550272006L;
    JButton mouseButton = new JButton("No Mouse Movement Yet!");

    public HandlingMouseEvent() {
        super("Handling Mouse Event");
        this.initFrame();
    }

    private void initFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.getContentPane().add(mouseButton);
        // Add a MouseListener to the JButton
        mouseButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println(((JButton) e.getSource()).getActionCommand());
                mouseButton.setText("Mouse has entered!");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println(((JButton) e.getSource()).getActionCommand());
                mouseButton.setText("Mouse has exited!");
            }
        });
    }

    public static void main(String[] args) {
        HandlingMouseEvent frame = new HandlingMouseEvent();
        frame.pack();
        frame.setVisible(true);
    }
}