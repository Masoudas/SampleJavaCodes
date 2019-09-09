package SampleJavaCodes.EventHandling;

import java.awt.event.*;

// So the classes that implement the following interfaces are the ones that can listen for an event.
// When an event occurs, the source invokes the appropriate method of the listener.

/// Listener interface implementations
class ActionListenerImplementer implements ActionListener{
    // Invoked when an action event occurs.
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}


class AdjustmentListenerImplementer implements AdjustmentListener{
    // Invoked when an adjustmen occurs.
    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {

    }
    
}

class ComponentListenerImplementer implements ComponentListener{
    // There's also a containter listener interface.
    @Override
    public void componentResized(ComponentEvent e) {
        // The source is resized
        
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        // The source is moved.
    }

    @Override
    public void componentShown(ComponentEvent e) {
        // The component is shown
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        // The component is hidden.
    }
    
}

