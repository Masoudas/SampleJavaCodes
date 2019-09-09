package SampleJavaCodes.EventHandling;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


class Example1 extends Frame implements MouseListener, MouseMotionListener, WindowListener{
    // This is the first example of a simple GUI which generates some event.
    // We report the current location of the mouse inside the window.
    // Also when a keyword button is pressed or released, we show it.

    private static final long serialVersionUID = 1L;
    String message = " ";
    int mouseX = 0, mouseY = 0;
    // private Frame frame = new Frame();
    public Example1(){
        // So this class is the subsriber to it's own elements.
        addMouseListener(this);
        addMouseMotionListener(this);
        addWindowListener(this);   // Why did we do this? Why not directly implement the listener method?
        addWindowListener(new AnotherWindowAdaptor());   // Why did we do this? Why not directly implement the listener method?
        addWindowListener(new MyWindowAdaptor());   // Why did we do this? Why not directly implement the listener method?
        
    }   

    @Override
    public void paint(Graphics g) {
        // We override this method, to print our string in the place we want inside of the window. This method is called by the repaint method.
        g.drawString(message, mouseX, mouseY);
    }

    // These methods are in the listener class.
    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        message = "*" + "Mouse dragged to x = " + mouseX + " y = " + mouseY;
        repaint();  // This is the method which puts new information in the window.

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        message = "*" + "Mouse moved to x = " + mouseX + " y = " + mouseY;
        repaint();  // This is the method which puts new information in the window.

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int button = e.getButton();
        if (button == MouseEvent.BUTTON1) {
            message = "Left button clicked";            
        }
        mouseX = e.getX();
        mouseY = e.getY();
        message += " *" + "Mouse moved to x = " + mouseX + " y = " + mouseY;
        repaint();  // This is the method which puts new information in the window.

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
    
    @Override
    public void windowOpened(WindowEvent e) {

    }
    
    //
    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("We could have closed the window here too!");
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

    public static void main(String[] args) {
        Example1 example1 = new Example1();
        
        example1.setSize(200, 200);
        example1.setTitle("Handling the events of a frame");
        example1.setVisible(true);

    }

}


// What is the adaptor class? The basic difference between the adaptor classes and the 
// interfaces is that adaptors allow one not to implement all the methods. So for example for the
// windowAdaptor, you don't need to implement the windowOpened, windowClosed and so forth.

class MyWindowAdaptor extends WindowAdapter{
    @Override
    public void windowClosing(WindowEvent e) {
        //System.exit (0);    // This is actually where we end the program.
    }
}


class AnotherWindowAdaptor implements WindowListener{

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Example1 ex1 = (Example1)e.getSource();
        
        System.out.println("Calling the window closing method of the class that caused this event from a subscriber");
        ex1.windowClosing(e);
        
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