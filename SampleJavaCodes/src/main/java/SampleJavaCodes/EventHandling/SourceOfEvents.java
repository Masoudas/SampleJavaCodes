package SampleJavaCodes.EventHandling;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.List;
import java.awt.Scrollbar;
import java.awt.TextComponent;
import java.awt.Window;

class SourceOFEvents{
    void sources(){
        // These are the sources can generate the events we have discussed in the AWTEventsExamples file.
        Frame frm = new Frame();
        //frm.addMouseWheelListener();
    
        Button btn = new Button("Ok");
        // btn.addMouseListener(); // This is an example of adding a listener.

        Checkbox checkbox = new Checkbox("Ok");

        Choice choice = new Choice();

        List list = new List(5);

        Scrollbar scrollbar = new Scrollbar(5);

        
        //TextComponent textComponent = new TextComponent();
        //Window window = new Window();


    }
}