package SwingLibrary.components_5.JToolBar_12;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

/**
 * As we might remember with JButtons, an action interface was provided to
 * create several buttons of with the same function, including same events. We
 * also want to extend AbstractAction to implement less methods.
 * 
 */
class UsingActionInterface extends AbstractAction {
    private static final long serialVersionUID = -6450965285998234347L;

    public UsingActionInterface(String action) {
        super(action);

        this.putValue(SHORT_DESCRIPTION, "An action");
        this.putValue(MNEMONIC_KEY, KeyEvent.VK_0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}