package SwingLibrary.creatingReusableFrames_3;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * It's been suggested that we should inherit a JFrame when creating a frame. But we'd better
 * inject it as a dependency. Moreover, all components and other containers are added as
 * fields of the class. Should they be static?
 * 
 */
class Basics extends JFrame {
    private static final long serialVersionUID = 1241586310862154227L;
    private final JButton button1 = new JButton();


    
}