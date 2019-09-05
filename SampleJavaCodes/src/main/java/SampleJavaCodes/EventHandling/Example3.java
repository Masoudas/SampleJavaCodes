package EventHandling;

import java.awt.*;
import java.awt.event.*;

// In this example, we handle key press event.
class Example3  extends WindowAdapter{
    private Frame frame;
    private Button okButton;
    private Button cancelButton;

    public Example3(){
        final GridBagLayout layout = new GridBagLayout();
        final GridBagConstraints c = new GridBagConstraints();
        frame = new Frame();

        int[] locationOk = {200, 200};
        okButton = generateButton("ok", locationOk);

        int[] locationCancel = {220, 220};
        cancelButton = generateButton("Cancel", locationCancel);
       
        frame.setLayout( layout );
        frame.setSize(500, 500);
        frame.setTitle("Handling key events");

        ++c.gridy;
        c.insets = new Insets(10,110,130,150);
        frame.add( okButton, c );

        ++c.gridy;
        c.insets = new Insets(10,50,60,60);
        frame.add( cancelButton, c );

        frame.addWindowListener(this);
    }

    private Button generateButton(String name, int[] location) {
        Button btn = new Button(name);
        //btn.setSize(5,5);
        //btn.setLocation(location[0], location[1]);
        return btn;
    }
    

    public void showFrame(){
        frame.setVisible(true);
    }

    public void addKeyListener(KeyListener kl){
        frame.addKeyListener(kl);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        frame.setVisible(false);
        frame.dispose();
    }

    public static void main(String[] args) {
        Example3 e3 = new Example3();
        
        KeyEventListener kl = new KeyEventListener();
        SecondKeyEventListener skl = new SecondKeyEventListener();

        e3.addKeyListener(kl);
        e3.addKeyListener(skl);
        
        e3.showFrame();

    }
}

class KeyEventListener implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Frame frame = (Frame)e.getSource();
        
        Graphics g = frame.getGraphics();
        
        String str = generateString(e);
        
        g.drawString(str, 100, 100);
        frame.repaint();
    }

    private String generateString(KeyEvent e) {
        int keyCode = e.getKeyCode();
        String str = "The key that was released was ";
        
        switch (keyCode){
            case KeyEvent.VK_ALT:
                str += "ALT";
                break;

            case KeyEvent.VK_F1:
                str += "F1";
                break;

            default:
                str += e.getKeyChar();
        }
        return str;
    }
    
}

class SecondKeyEventListener extends KeyAdapter{
    @Override
    public void keyPressed(KeyEvent e) {
        Frame frame = (Frame)e.getSource();
        
        Graphics g = frame.getGraphics();       
        g.drawString("The key that was pressed was " + e.getKeyChar(), 100, 100);
        frame.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}