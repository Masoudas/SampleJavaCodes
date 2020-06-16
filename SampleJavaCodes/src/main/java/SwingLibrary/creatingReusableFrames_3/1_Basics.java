package SwingLibrary.creatingReusableFrames_3;

import javax.swing.JButton;

/**
 * It's been suggested that we should inherit a JFrame when creating a frame. But we'd better
 * inject it as a dependency. Moreover, all components and other containers are added as
 * fields of the class. Should they be static?
 */
class Basics {
    private final JButton button1 = new JButton();


    
}