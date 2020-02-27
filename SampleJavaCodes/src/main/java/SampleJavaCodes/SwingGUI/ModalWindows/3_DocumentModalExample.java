/**
 * In this example, we try and create a document modal type dialog.
 * 
 */


package SampleJavaCodes.SwingGUI.ModalWindows;

import java.awt.event.*;
import java.awt.Dialog;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

class DocumentModalType{
    JFrame f = new JFrame();

    JDialog dialog = new JDialog(f, Dialog.ModalityType.DOCUMENT_MODAL);

    JButton button = new JButton();

    DocumentModalType(){
        button.setText("Press");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JLabel jLabel = new JLabel();
                jLabel.setText("Inside the new label");
                
                dialog.setSize(200, 200);
                dialog.setBounds(400, 400, 250, 250);   // Sets the window with respect to the bounds of screen.
                dialog.add(jLabel);

                dialog.setVisible(true);
            }
        });
            
            
        f.setBounds(350, 350, 750, 750);
        f.setSize(400, 400);
        f.add(button);
        f.setVisible(true);

        JFileChooser fileChooser = new JFileChooser();
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                DocumentModalType dm = new DocumentModalType();
            }
            
        });
    }

}