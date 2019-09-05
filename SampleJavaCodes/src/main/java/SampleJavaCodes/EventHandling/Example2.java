package EventHandling;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


// This is the same as example 1, with the exception that we define a method to subscribe to the object.
class Example2 extends Frame{

    private static final long serialVersionUID = 1L;
    String message = " ";
    int mouseX = 0, mouseY = 0;
    
    // private Frame frame = new Frame();
    public Example2(){        
    }   

    @Override
    public synchronized void addMouseListener(MouseListener l) {
        super.addMouseListener(l);
    }

    @Override
    public synchronized void addMouseMotionListener(MouseMotionListener l) {
        super.addMouseMotionListener(l);
    }

    @Override
    public synchronized void addWindowListener(WindowListener l) {
        super.addWindowListener(l);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(message, mouseX, mouseY);
    }


    public static void main(String[] args) {
        Example1 example1 = new Example1();
        
        ListenerToMouseClick listenerToMouseClick = new ListenerToMouseClick();
        ListenerToMouseMotion listenerToMouseMotion = new ListenerToMouseMotion();
        ListenerToWindow listenerToWindow = new ListenerToWindow();

        example1.addMouseListener(listenerToMouseClick);
        example1.addMouseMotionListener(listenerToMouseMotion);
        example1.addWindowListener(listenerToWindow);

        example1.setSize(200, 200);
        example1.setTitle("Handling the events of a frame");

        example1.setVisible(true);
    }

}

class ListenerToMouseMotion implements MouseMotionListener{

    @Override
    public void mouseDragged(MouseEvent e) {
        Example1 ex1 = (Example1)e.getSource();
        
        ex1.mouseX = e.getX();
        ex1.mouseY = e.getY();
        ex1.message = "*" + "Mouse dragged to x = " + ex1.mouseX + " y = " + ex1.mouseY;
        ex1.repaint();  // This is the method which puts new information in the window.
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}

class ListenerToMouseClick implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
        Example1 ex1 = (Example1)e.getSource();
        int button = e.getButton();

        if (button == MouseEvent.BUTTON1) {
            ex1.message = "Left button clicked";            
        }

        ex1.mouseX = e.getX();
        ex1.mouseY = e.getY();
        ex1.message += " *" + "Mouse moved to x = " +  ex1.mouseX + " y = " +  ex1.mouseY;
        ex1.repaint();  // This is the method which puts new information in the window.

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}



class ListenerToWindow implements WindowListener{

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Example1 ex1 = (Example1)e.getSource();
        
        // The proper way of closing a frame.
        ex1.setVisible(false);
        ex1.dispose();

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}