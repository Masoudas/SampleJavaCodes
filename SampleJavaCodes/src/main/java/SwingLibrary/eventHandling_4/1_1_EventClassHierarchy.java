package SwingLibrary.eventHandling_4;

/**
 * So if we look at 1_EventClassHierarchy.java, there are several functions of
 * interest in ActionEvent.
 * 
 * Example is getModifiers(), which indicates whether and which modifier key
 * (like alt, ctrl, etc) is pressed during the event.
 * 
 * paramString() returns an string name indicating event name, used for
 * debugging mostly.
 * 
 * getActionCommand() returns the name of the button. setActionCommand()
 * (re)sets the name
 * 
 * What are these two good for? Suppose we want to show or hide some detail on
 * the screen, using this button. We use getActionCommand() and check the name
 * of the button, do the action accordingly, then set the name using
 * setActionCommand().
 */