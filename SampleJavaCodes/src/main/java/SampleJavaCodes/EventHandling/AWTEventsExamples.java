package SampleJavaCodes.EventHandling;

import java.awt.Adjustable;
import java.awt.Component;
import java.awt.event.*;
import java.lang.*;

class Examples{
    // These are the classes that are generated by the source upon the occurence of the event.
    
    // It seems that we don't have access to how these classes are generated mostly, we usually have them
    // in the event listener classes.
    void actionEvent(){
        // Action event when a button is clicked, a list is double clicked, or menu Item is selected.
        // We can assign several parameters in the constructor to indicate what happened when the event
        // was generated.
        
        //ActionEvent(src=this, type=10, cmd="Something", when=1.111, modifiers=10)
        ActionEvent actionEvent = new ActionEvent(this, ActionEvent.ACTION_FIRST, "Something", ActionEvent.ALT_MASK);
        // src is the source of the event generator.
        // type indicates the type of the event (meaning maybe click, double click on list and so forth)
        // cmd indicates a command! 
        // modifiers indicates whether any modifier keys (like alt, shift or anything else) were pressed/
        // when indicates the time when the event was generated!
        

        System.out.println(actionEvent.getID());    // This method returns the event type, which is the type we assigned.
        System.out.println(actionEvent.getSource());    // Returns the source object of this method. 
        System.out.println(actionEvent.getModifiers()); // Returns the modifier.
        //actionEvent.getWhen();
        System.out.println(actionEvent.getActionCommand());// Getting the command.
    }

    void adjustmentEvent(){
        // This event is generated by moving the scroll bar.
        // AdjustmentEvent(source, id, type, value) is one of the constructors.

        AdjustmentEvent adjustmentEvent = new AdjustmentEvent((Adjustable) this, AdjustmentEvent.BLOCK_DECREMENT, 1, 1);
        
    }

    void componentEvent(){
        // This event is generated when the size or visibility of an icon changes.
        // ComponentEvent(source, id)

        
     //   ComponentEvent componentEvent = new ComponentEvent((Component) this, 1);
    }

    void containerEvent(){
        // This is generated when an item is added or removed from a component.
        // ContainerEvent containerEvent = new ContainerEvent(source, id, child);
    }

    void focusEvent(){
        // Generated when a component loses or gains event.
        // Constructor can be new FocusEvent(source, id);
        //FocusEvent focusEvent = new FocusEvent(source, id);
    }

    void inputEvent(){
        /* Input event is an abstract class for KeyEvent and MouseEvent.
        new MouseEvent(source, id, when, modifiers, x, y, clickCount, popupTrigger);
        */

        
        /*MouseEvent mouseEvent = new MouseEvent(
            this, 1, MouseEvent.COMPONENT_EVENT_MASK, MouseEvent.MOUSE_CLICKED, 50, 50, 1);
        mouseEvent.getXOnScreen();
        mouseEvent.isAltDown();*/

        //KeyEvent keyEvent = new KeyEvent(source, id, when, modifiers, keyCode, keyChar, keyLocation)

    }

    void itemEvent(){
        /* Generated when check box or a list item is clicked or when a checkable menu item is selected or deselected.
        */
        //ItemEvent itemEvent = new ItemEvent(source, id, item, stateChange);
    }

    void mouseWheelEvent(){

    }

    void textEvent(){
        // Generated when text is written.
    }

    void windowEvent(){
        // There are ten types associated with it:
        // WindowEvent.WINDOW_ACTIVATED
        // WindowEvent.WINDOW_CLOSED
        // And so forth.
    }

}
