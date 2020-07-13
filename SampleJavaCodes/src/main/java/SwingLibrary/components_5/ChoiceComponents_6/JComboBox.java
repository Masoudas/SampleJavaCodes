package SwingLibrary.components_5.ChoiceComponents_6;

import java.awt.event.ItemEvent;

import javax.swing.JComboBox;

/**
 * We can provide a list of items to JComboBox, and add and remove from it later
 * on using addItem or RemoveItem.
 */
class JComboBoxExample {
    public static void main(String[] args) {
        String[] choices = { "Male", "Female", "Unknown" };

        JComboBox<String> box = new JComboBox<>(choices);
        box.addItem("Maleish");

        box.getSelectedIndex(); // The selected Item!

        box.addItemListener(item -> {
            int state = item.getStateChange();
            if (state == ItemEvent.SELECTED){

            }
            else if (state == ItemEvent.DESELECTED){
                
            }
        }
            ); // Listens to when an Item is selected.

    }

}